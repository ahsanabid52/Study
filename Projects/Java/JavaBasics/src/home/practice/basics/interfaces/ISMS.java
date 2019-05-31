package home.practice.basics.interfaces;

@FunctionalInterface
public interface ISMS {

  static int number = 10;

  default void read(String message) {
    System.out.println("I have read the message: " + message);
  }

  String write(String message);
}