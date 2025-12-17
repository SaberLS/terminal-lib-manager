package pl.wszib.java.advanced.services.user;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import pl.wszib.java.advanced.database.IUserRepository;
import pl.wszib.java.advanced.model.Role;
import pl.wszib.java.advanced.model.User;
import pl.wszib.java.advanced.services.password.IPasswordService;

@Service
@AllArgsConstructor
public class UserService implements IUserService {
  private final IUserRepository userRepository;
  private final IPasswordService passwordService;

  @Override
  public Optional<User> login(String username, String password) {
    return userRepository.findByUserName(username)
        .filter(user -> passwordService.matches(password, user.getPassword()));
  }

  @Override
  public User register(String username, String password, Role role) throws IllegalArgumentException {
    if (userRepository.findByUserName(username).isPresent()) {
      throw new IllegalArgumentException("User already exists");
    }

    String hash = passwordService.hash(password);
    User user = new User(username, hash, role);
    userRepository.addUser(user);
    return user;
  }

  @Override
  public Optional<User> findByUsername(String username) {
    return userRepository.findByUserName(username);
  }
}
