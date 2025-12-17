package pl.wszib.java.advanced.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import lombok.Getter;
import pl.wszib.java.advanced.model.Book;

@Repository
@Getter
public class BookRepository implements IBookRepository {
  private final List<Book> books = new ArrayList<>();

  @Override
  public boolean borrowBook(String isbn) {
    Optional<Book> book = this.findBookByISBN(isbn);

    if (book.isPresent() && book.get().isAvailable()) {
      book.get().setAvailable(false);
      return true;
    }

    return false;
  }

  @Override
  public boolean addBook(Book book) {
    return this.books.add(book);
  }

  @Override
  public Optional<Book> removeBook(String isbn) {
    for (int i = 0; i < this.books.size(); i++)
      if (this.books.get(i).getIsbn().equals(isbn))
        return Optional.of(this.books.remove(i));

    return Optional.empty();
  }

  @Override
  public Optional<Book> findBookByISBN(String isbn) {
    for (Book book : this.getBooks())
      if (book.getIsbn().equals(isbn))
        return Optional.of(book);

    return Optional.empty();
  }

  @Override
  public List<Book> findBookByAuthor(String author) {
    List<Book> list = new ArrayList<>();

    for (Book book : this.getBooks())
      if (book.getAuthor().equals(author))
        list.add(book);

    return list;
  }

  @Override
  public Optional<Book> updateBook(String isbn, String newTitle, String newAuthor, boolean available) {
    Optional<Book> bookOpt = findBookByISBN(isbn);

    bookOpt.ifPresent(book -> {
      book.setTitle(newTitle);
      book.setAuthor(newAuthor);
      book.setAvailable(available);
    });

    return bookOpt;
  }
}
