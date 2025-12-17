package pl.wszib.java.advanced.gui;

import java.util.List;

import pl.wszib.java.advanced.model.Book;
import pl.wszib.java.advanced.model.User;
import pl.wszib.java.advanced.model.operation.Operation;

public interface IGUI {
  Operation showMenuAndReadChoice(Menu menu);

  String readISBN();

  String readAuthor();

  void listBooks(List<Book> books);

  void showBorrowResultMessage(boolean success);

  void showWrongOptionMessage();

  User readLoginAndPassword();

  Book readBook();

  void showResultAddBookMessage(boolean success);

  void showResultRemoveBookMessage(boolean success);

  void showExitMessage();

  void showBook(Book book);

  void showBookNotFoundMessage();
}
