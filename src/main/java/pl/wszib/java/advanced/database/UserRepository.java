package pl.wszib.java.advanced.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.Getter;
import pl.wszib.java.advanced.model.User;

@Getter
public class UserRepository implements IUserRepository {
  private final List<User> users = new ArrayList<>();

  @Override
  public Optional<User> findByUserName(String username) {
    for (User user : this.users)
      if (user.getUsername().equals(username))
        return Optional.of(user);

    return Optional.empty();
  }

}
