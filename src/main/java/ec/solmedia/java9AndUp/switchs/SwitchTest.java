package ec.solmedia.java9AndUp.switchs;

public class SwitchTest {

  public static void main(String[] args) {
    // Switch Statements/Expressions - java 12
    enhancedSwitch(1);
    enhancedSwitch(2);

    var oneResult = switchReturning(1);
    System.out.println(oneResult);
    var twoResult = switchReturning(2);
    System.out.println(twoResult);

    switchMultipleCases(1);
    switchMultipleCases(212);

  }

  static void enhancedSwitch(int valueToEvaluate) {
    switch (valueToEvaluate) {
      case 1 -> System.out.println("one");
      case 2 -> System.out.println("two");
      case 3 -> System.out.println("three");
      default -> System.out.println("None");
    }
  }

  static String switchReturning(int valueToEvaluate) {
    return switch (valueToEvaluate) {
      case 1 -> "one";
      case 2 -> "two";
      case 3 -> "three";
      default -> "None";
    };
  }

  static void switchMultipleCases(int valueToEvaluate) {
    switch (valueToEvaluate) {
      case 1, 2, 3 -> System.out.println("one, two or three");
      default -> System.out.println("None");
    }
  }
}
