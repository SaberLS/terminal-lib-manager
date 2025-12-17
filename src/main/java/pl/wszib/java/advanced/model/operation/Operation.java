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
  EXIT("Exit application"),

  FIND_BOOK("Find Book"),
  FIND_BY_AUTHOR("Look for author"),
  FIND_BY_ISBN("Look for ISBN");

  private final String description;
}
