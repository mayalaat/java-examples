package ec.solmedia.java8.fizzbuzz;

import java.util.Optional;

/**
 * <p>
 * Fizz buzz is a group word game for children to teach them about division.[1]
 * Players take turns to count incrementally, replacing any number divisible by
 * three with the word "fizz", and any number divisible by five with the word
 * "buzz".
 * </p>
 * </p>This class is my implemetation in Java 8 Fizz Buzz</p>
 * 
 * @author Alejandro Ayala
 *
 */
public class Java6FizzBuzz {

	public static void main(String[] args) {

		for (int i = 1; i <= 100; i++) {
			fizzbuzz(i);
			fizzbuzzJava8(i);
		}
	}

	/**
	 * Tipical Fizz Buzz implemetation before Java 8
	 * 
	 * @param number
	 *            Number to evaluate
	 */
	private static void fizzbuzz(int number) {
		String cad = number % 15 == 0 ? "Fizz Buzz" : number % 3 == 0 ? "Fizz"
				: number % 5 == 0 ? "Buzz" : String.valueOf(number);

		System.out.printf("%s, ", cad);
	}

	/**
	 * Java 8 Implemetation
	 * 
	 * @param number
	 *            Number to evaluate
	 */
	private static void fizzbuzzJava8(int number) {
		String result = Optional
				.of(number)
				.map(n -> (n % 3 == 0 ? "Fizz" : "")
						+ (n % 5 == 0 ? "Buzz" : "")).get();

		System.out.printf("%s, ", result.isEmpty() ? String.valueOf(number)
				: result);
	}
}
