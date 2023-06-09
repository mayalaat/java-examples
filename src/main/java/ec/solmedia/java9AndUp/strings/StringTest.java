package ec.solmedia.java9AndUp.strings;

public class StringTest {

  public static void main(String[] args) {
    //  repeat, isBlank, strip, stripLeading, stripTrailing, lines - java 11
    String name = "  John Doe  ";
    System.out.println(name.repeat(3)); // John Doe    John Doe    John Doe
    System.out.println(name.isBlank()); // false
    System.out.println(name.strip()); // John Doe
    System.out.println(name.stripLeading()); // John Doe    John Doe    John Doe
    System.out.println(name.stripTrailing()); //  John Doe    John Doe    John Doe
    System.out.println(name.lines()); // Stream<String>
  }

}
