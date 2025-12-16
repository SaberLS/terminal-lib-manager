package pl.wszib.java.advanced.database;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Getter;
import pl.wszib.java.advanced.exceptions.CanNotBorrowBookException;
import pl.wszib.java.advanced.model.Book;

@Component
@Getter
public class BookRepository implements IBookRepository {
  private final List<Book> books = new ArrayList<>();

  @Override
  public void borrowBook(String isbn) {
    for (Book book : this.getBooks())
      if (book.getIsbn().equals(isbn) && !book.isAvailable()) {
        book.setAvailable(false);
        return;
      }

    throw new CanNotBorrowBookException();
  }
}
