package pl.wszib.java.advanced.core;

import java.util.Set;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import pl.wszib.java.advanced.database.IBookRepository;
import pl.wszib.java.advanced.gui.IGUI;
import pl.wszib.java.advanced.gui.Menu;
import pl.wszib.java.advanced.model.User;
import pl.wszib.java.advanced.model.operation.Operation;
import pl.wszib.java.advanced.services.permission.IPermissionService;

@Component
@RequiredArgsConstructor
public class Core implements ICore {
  private final IPermissionService permissionService;
  private final IBookRepository bookRepository;
  private final IGUI gui;

  @Override
  public void run() {
    User user = new User("user", "user");

    Set<Operation> permissions = permissionService.getPermissions(user);

    Menu menu = new Menu(permissions);

    while (true) {
      Operation chosenOperation = gui.showMenuAndReadChoice(menu);

      switch (chosenOperation) {
        case LIST_BOOKS -> gui.listBooks(bookRepository.getBooks());
        case BORROW_BOOK -> {
          String isbn = gui.readISBN();
          gui.showBorrowResultMessage(bookRepository.borrowBook(isbn));
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
