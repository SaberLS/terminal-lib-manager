package pl.wszib.java.advanced.services.auth;

public interface IAuthService {
  boolean authenticate(String username, String password);
}
