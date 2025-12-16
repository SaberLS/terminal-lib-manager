package pl.wszib.java.advanced.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {
  private String username;
  private String password;
  private Role role;

  public User(String username, String password) {
    this.password = password;
    this.username = username;
  }

  public boolean isAdmin() {
    return this.role == Role.ADMIN;
  }
}
