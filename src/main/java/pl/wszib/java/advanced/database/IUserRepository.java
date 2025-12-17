package pl.wszib.java.advanced.database;

import java.util.List;
import java.util.Optional;

import pl.wszib.java.advanced.model.User;

public interface IUserRepository {
  Optional<User> findByUserName(String userName);

  List<User> getUsers();

  boolean addUser(User user);
}
