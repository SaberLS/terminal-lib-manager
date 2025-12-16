package pl.wszib.java.advanced.gui;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import lombok.Getter;
import pl.wszib.java.advanced.model.operation.Operation;

@Getter
public class Menu {
  private final Map<Integer, Operation> items = new LinkedHashMap<>();

  public Menu(Set<Operation> operations) {
    int index = 1;
    for (Operation op : operations) {
      items.put(index++, op);
    }
  }
}
