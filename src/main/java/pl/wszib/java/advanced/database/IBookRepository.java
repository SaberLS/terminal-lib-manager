package pl.wszib.java.advanced.database;

import java.util.List;
import java.util.Optional;

import pl.wszib.java.advanced.model.Book;

public interface IBookRepository {
  boolean borrowBook(String isbn);

  boolean addBook(Book book);

  Optional<Book> removeBook(String isbn);

  public List<Book> getBooks();

  Optional<Book> findBookByISBN(String isbn);

  Optional<Book> findBookByAuthor(String author);
}
