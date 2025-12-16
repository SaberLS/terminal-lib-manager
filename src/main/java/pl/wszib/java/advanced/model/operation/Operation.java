package pl.wszib.java.advanced.model.operation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Operation {
  LIST_BOOKS("List all books"),
  BORROW_BOOK("Borrow a book"),
  ADD_BOOK("Add a new book"),
  REMOVE_BOOK("Remove a book"),
  EXIT("Exit application");

  private final String description;
}
