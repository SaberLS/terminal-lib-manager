package pl.wszib.java.advanced.database;

import java.util.List;

import pl.wszib.java.advanced.model.Book;

public interface IBookRepository {
  void borrowBook(String isbn);

  public List<Book> getBooks();
}
