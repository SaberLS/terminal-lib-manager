package pl.wszib.java.advanced.security;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

import pl.wszib.java.advanced.model.Role;
import pl.wszib.java.advanced.model.operation.Operation;

public class RolePermissions {
  private static final Map<Role, Set<Operation>> PERMISSIONS = new EnumMap<>(Role.class);

  static {
    PERMISSIONS.put(Role.USER, EnumSet.of(
        Operation.LIST_BOOKS,
        Operation.BORROW_BOOK,
        Operation.FIND_BOOK,
        Operation.EXIT));

    PERMISSIONS.put(Role.ADMIN, EnumSet.of(
        Operation.LIST_BOOKS,
        Operation.BORROW_BOOK,
        Operation.FIND_BOOK,
        Operation.ADD_BOOK,
        Operation.REMOVE_BOOK,
        Operation.EXIT));
  }

  public static Set<Operation> getPermissions(Role role) {
    return PERMISSIONS.get(role);
  }
}
