package pl.wszib.java.advanced.configuration;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({
    "pl.wszib.java.advanced.core",
    "pl.wszib.java.advanced.database",
    "pl.wszib.java.advanced.gui",
    "pl.wszib.java.advanced.security",
    "pl.wszib.java.advanced.services"
})
public class AppConfiguration {

  @Bean
  public Scanner scanner() {
    return new Scanner(System.in);
  }
}
