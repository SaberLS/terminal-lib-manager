package pl.wszib.java.advanced.services.auth;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import pl.wszib.java.advanced.database.IUserRepository;
import pl.wszib.java.advanced.model.User;
import pl.wszib.java.advanced.services.password.IPasswordService;

@Service
@AllArgsConstructor
public class AuthService implements IAuthService {
  private final IPasswordService passwordService;
  private final IUserRepository userRepository;

  @Override
  public boolean authenticate(String username, String rawPassword) {
    Optional<User> user = this.userRepository.findByUserName(username);

    return user.isPresent() &&
        this.passwordService.matches(rawPassword, user.get().getPassword());
  }
}
