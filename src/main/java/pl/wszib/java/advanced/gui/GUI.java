package pl.wszib.java.advanced.gui;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import pl.wszib.java.advanced.model.Book;
import pl.wszib.java.advanced.model.User;
import pl.wszib.java.advanced.model.operation.Operation;

@Component
@RequiredArgsConstructor
public class GUI implements IGUI {
  private final Scanner scanner;

  @Override
  public Operation showMenuAndReadChoice(Menu menu) {
    Map<Integer, Operation> items = menu.getItems();

    items.forEach(
        (key, op) -> System.out.println(key + ". " + op.getDescription()));

    int choice = scanner.nextInt();
    scanner.nextLine(); // newline
    return items.get(choice);
  }

  @Override
  public String readISBN() {
    System.out.println("ISBN: ");
    return this.scanner.nextLine();
  }

  @Override
  public void listBooks(List<Book> books) {
    for (Book book : books)
      System.out.println(book);
  }

  @Override
  public void showBorrowSuccessMessage(boolean success) {
    System.out.println(
        success ? "Book borrowed successfully." : "Cannot borrow the book.");
  }

  @Override
  public void showWrongOptionMessage() {
    System.out.println("Wrong option. Please try again.");
  }

  @Override
  public User readLoginAndPassword() {
    System.out.println("Login: ");
    String login = this.scanner.nextLine();

    System.out.println("Password: ");

    return new User(login, this.scanner.nextLine());
  }

}
