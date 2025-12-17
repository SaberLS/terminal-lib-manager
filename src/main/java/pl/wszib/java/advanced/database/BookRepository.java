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
    for (Book book : this.getBooks())
      if (book.getIsbn().equals(isbn)) {
        if (!book.isAvailable()) {
          book.setAvailable(false);
          return true;
        }
        return false;
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
}
