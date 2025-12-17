package pl.wszib.java.advanced.services.password;

public interface IPasswordService {
  public String hash(String rawPassword);

  public boolean matches(String rawPassword, String hashedPassword);
}
