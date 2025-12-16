package pl.wszib.java.advanced.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Book {
  private final String title;
  private final String author;
  private final String isbn;
  private boolean available;
}
