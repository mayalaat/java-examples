package ec.solmedia.java9AndUp.format;

import java.text.NumberFormat;
import java.util.Locale;

public class FormatTest {

  public static void main(String[] args) {
    // compat number format - java 12
    final var followers =NumberFormat.getCompactNumberInstance(Locale.US,  NumberFormat.Style.SHORT);
    followers.setMaximumFractionDigits(1);
    System.out.println(followers.format(121_212).concat(" followers")); // 121.2K followers
  }

}
