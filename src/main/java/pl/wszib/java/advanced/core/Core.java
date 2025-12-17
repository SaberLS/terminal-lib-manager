package pl.wszib.java.advanced.core;

import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import pl.wszib.java.advanced.database.IBookRepository;
import pl.wszib.java.advanced.gui.IGUI;
import pl.wszib.java.advanced.gui.Menu;
import pl.wszib.java.advanced.model.Book;
import pl.wszib.java.advanced.model.Role;
import pl.wszib.java.advanced.model.User;
import pl.wszib.java.advanced.model.operation.Operation;
import pl.wszib.java.advanced.services.permission.IPermissionService;
import pl.wszib.java.advanced.services.user.IUserService;

@Component
@RequiredArgsConstructor
public class Core implements ICore {
  private final IPermissionService permissionService;
  private final IBookRepository bookRepository;
  private final IUserService userService;
  private final IGUI gui;

  @Override
  public void run() {
    this.userService.register("user", "123", Role.USER);
    this.userService.register("admin", "456", Role.ADMIN);
    this.bookRepository.addBook(new Book("12345", "Møøse Effects", "Olaf Prot", true));
    this.bookRepository
        .addBook(new Book("67890", "The Høt Hands of an Oslo Dentist", "Bjørn Irkestøm-Slater Walker", false));
    this.bookRepository.addBook(
        new Book("54321", "Llamas are dangerous", "14 North Chilean Guanacos", true));

    Optional<User> userOpt = userService.login(
        gui.readLogin(),
        gui.readPassword());

    if (userOpt.isEmpty()) {
      gui.showLoginFailedMessage();
      return;
    }

    Set<Operation> permissions = permissionService.getPermissions(userOpt.get());

    Menu menu = new Menu(permissions);

    while (true) {
      Operation chosenOperation = gui.showMenuAndReadChoice(menu);

      switch (chosenOperation) {
        case LIST_BOOKS -> gui.listBooks(bookRepository.getBooks());
        case BORROW_BOOK -> {
          String isbn = gui.readISBN();
          gui.showBorrowResultMessage(bookRepository.borrowBook(isbn));
        }
        case FIND_BOOK -> {
          Set<Operation> operations = EnumSet.of(Operation.FIND_BY_AUTHOR, Operation.FIND_BY_ISBN);

          Menu findMenu = new Menu(operations);
          switch (gui.showMenuAndReadChoice(findMenu)) {
            case FIND_BY_AUTHOR -> {
              List<Book> bookList = bookRepository.findBookByAuthor(gui.readAuthor());

              if (bookList.isEmpty())
                gui.showBookNotFoundMessage();
              else
                gui.listBooks(bookList);
            }
            case FIND_BY_ISBN -> {
              Optional<Book> book = bookRepository.findBookByISBN(gui.readISBN());

              book.ifPresentOrElse(gui::showBook, gui::showBookNotFoundMessage);
            }
            default -> gui.showWrongOptionMessage();
          }
        }
        case ADD_BOOK -> {
          gui.showResultAddBookMessage(bookRepository.addBook(gui.readBook()));
        }
        case REMOVE_BOOK -> {
          gui.showResultRemoveBookMessage(bookRepository.removeBook(gui.readISBN()).isPresent());
        }
        case EXIT -> {
          gui.showExitMessage();
          return;
        }

        default -> gui.showWrongOptionMessage();
      }
    }
  }
}
