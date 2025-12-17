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
  public String readAuthor() {
    System.out.println("Author: ");
    return this.scanner.nextLine();
  }

  @Override
  public void listBooks(List<Book> books) {
    for (Book book : books)
      System.out.println(book);
  }

  @Override
  public void showBorrowResultMessage(boolean success) {
    System.out.println(
        success ? "Book borrowed successfully." : "Cannot borrow the book.");
  }

  @Override
  public void showWrongOptionMessage() {
    System.out.println("Wrong option. Please try again.");
  }

  @Override
  public Book readBook() {
    return new Book(
        this.readISBN(),
        this.readTitle(),
        this.readAuthor(),
        this.readAvailability());
  }

  @Override
  public void showResultAddBookMessage(boolean success) {
    System.out.println(
        success ? "Book added successfully." : "Cannot add the book.");
  }

  @Override
  public void showResultRemoveBookMessage(boolean success) {
    System.out.println(
        success ? "Book removed successfully." : "Cannot remove the book.");
  }

  @Override
  public void showExitMessage() {
    System.out.println("Goodbye!");
  }

  @Override
  public void showBook(Book book) {
    System.out
        .println("Title: " + book.getTitle() + "\nAuthor: " + book.getAuthor() + "\nAvailable: " + book.isAvailable()
            + "\nISBN: " + book.getIsbn());
  }

  @Override
  public void showBookNotFoundMessage() {
    System.out.println("Book not found");
  }

  @Override
  public String readLogin() {
    System.out.println("Login: ");
    return this.scanner.nextLine();
  }

  @Override
  public String readPassword() {
    System.out.println("Password: ");
    return this.scanner.nextLine();
  }

  @Override
  public void showLoginFailedMessage() {
    System.out.println("Login Failed");
  }

  @Override
  public String readTitle() {
    System.out.println("Title: ");
    return this.scanner.nextLine();
  }

  @Override
  public boolean readAvailability() {
    System.out.println("Available:\n1. Yes\n2. No");

    return this.scanner.nextInt() == 1;
  }

  @Override
  public void showEditBookResult(boolean success) {
    System.out.println(
        success ? "Book edited successfully." : "Cannot edit the book.");
  }

}
