package pl.wszib.java.advanced.core;

import java.util.Set;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import pl.wszib.java.advanced.database.IBookRepository;
import pl.wszib.java.advanced.gui.IGUI;
import pl.wszib.java.advanced.gui.Menu;
import pl.wszib.java.advanced.model.Role;
import pl.wszib.java.advanced.model.User;
import pl.wszib.java.advanced.model.operation.Operation;
import pl.wszib.java.advanced.services.PermissionService;

@Component
@RequiredArgsConstructor
public class Core implements ICore {
  private final PermissionService permissionService;
  private final IBookRepository bookRepository;
  private final IGUI gui;

  @Override
  public void run() {
    User user = new User("user", "user", Role.ADMIN);

    Set<Operation> permissions = permissionService.getPermissions(user);

    Menu menu = new Menu(permissions);

    while (true) {
      Operation chosenOperation = gui.showMenuAndReadChoice(menu);

      System.out.println(chosenOperation);
    }
  }
}
