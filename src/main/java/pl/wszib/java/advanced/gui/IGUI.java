package pl.wszib.java.advanced.gui;

import java.util.List;

import pl.wszib.java.advanced.model.Book;
import pl.wszib.java.advanced.model.User;
import pl.wszib.java.advanced.model.operation.Operation;

public interface IGUI {
  Operation showMenuAndReadChoice(Menu menu);

  String readISBN();

  void listBooks(List<Book> cars);

  void showBorrowSuccessMessage(boolean success);

  void showWrongOptionMessage();

  User readLoginAndPassword();
}
