package pl.wszib.java.advanced.services.user;

import java.util.Optional;

import pl.wszib.java.advanced.model.Role;
import pl.wszib.java.advanced.model.User;

public interface IUserService {
  public Optional<User> login(String username, String password);

  public User register(String username, String password, Role role);

  public Optional<User> findByUsername(String username);
}
