package pl.wszib.java.advanced;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.wszib.java.advanced.configuration.AppConfiguration;
import pl.wszib.java.advanced.core.Core;
import pl.wszib.java.advanced.core.ICore;

public class App {
  public static void main(String[] args) {
    try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
        AppConfiguration.class)) {
      ICore core = context.getBean(Core.class);
      core.run();
    }
  }
}
