package ec.solmedia.java8.datetime;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * <p>
 * All classes of new Date and Time API of Java 8 are Immutable and thread-safe,
 * as opposed to existing Date and Calendar API, where key classes e.g.
 * java.util.Date or SimpleDateFormat are not thread-safe.
 * </p>
 * <p>
 * <li>Instant - It represents a time-stamp e.g. 2014-01-14T02:20:13.592Z and
 * can be obtained from java.time.Clock class as shown below :<br>
 * <code>Instant current = Clock.system(ZoneId.of("Asia/Tokyo")).instant();</code>
 * </li>
 * <li>LocalDate - represents a date without a time e.g. 2014-01-14. It can be
 * used to store birthday, anniversary, date of joining etc.</li>
 * <li>LocalTime - represents time without a date</li>
 * <li>LocalDateTime - is used to combine date and time, but still without any
 * offset or time-zone</li>
 * <li>ZonedDateTime - a complete date-time with time-zone and resolved offset
 * from UTC/Greenwich</li>
 * </p>
 * 
 * Read more:
 * http://javarevisited.blogspot.com/2015/03/20-examples-of-date-and-time
 * -api-from-Java8.html
 * 
 * @author Alejandro Ayala
 *
 */
public class Java8LocalDateTime {

	public static void main(String[] args) {
		LocalTime time = LocalTime.now();
		System.out.printf("Time is %s %n %n", time);
		// output: 10:04:28.688

		LocalDate today = LocalDate.now();
		System.out.printf("Date is %s %n %n", today);
		// output: 2015-03-27

		int year = today.getYear();
		int month = today.getMonthValue();
		int day = today.getDayOfMonth();

		System.out.printf("Year: %d, Month: %d, Day: %d %n %n", year, month,
				day);
		// output: Year: 2015, Month: 3, Day: 27

		LocalDate birthday = LocalDate.of(1984, 6, 1);
		System.out.printf("Your birthday is: %s %n %n", birthday);
		// output: 1984-06-01

		LocalDate date1 = LocalDate.of(2015, 3, 27);
		if (today.equals(date1)) {
			System.out.printf("Today %s is equal to %s %n %n", today, date1);
			// output: Today 2015-03-27 is equal to 2015-03-27
		}

		/** check if today is your birthday */
		MonthDay monthDayBirth = MonthDay.of(birthday.getMonthValue(),
				birthday.getDayOfMonth());
		MonthDay currentMonthDay = MonthDay.from(today);
		if (currentMonthDay.equals(monthDayBirth)) {
			System.out.println("¡¡HAPPY BIRTHDAY!! \n");
		} else {
			System.out.println("Today is not your birthday! \n");
		}

		/** add hours in time */
		LocalTime newTime = time.plusHours(2);// add two hours
		System.out.printf("The time after two hours is %s %n %n", newTime);

		/** add weeks in date */
		System.out.printf("Today is: %s %n %n", today);
		// output: Today is: 2015-03-27
		LocalDate newDate = today.plus(1, ChronoUnit.WEEKS);
		// LocalDate newDate = today.plusWeeks(1);
		System.out.printf("Date after 1 week is %s %n %n", newDate);
		// output: Date after 1 week: 2015-04-03

		/** before an after */
		LocalDate beforeDate = today.minus(1, ChronoUnit.YEARS);
		System.out.printf("Date before 1 year is %s %n %n", beforeDate);
		// output: Date before 1 year: 2014-03-27
		LocalDate afterDate = today.plus(1, ChronoUnit.YEARS);
		System.out.printf("Date after 1 year is %s %n %n", afterDate);
		// output: Date after 1 year: 2016-03-27

		/** Clock dependency injection */
		// Returns the current time based on your system clock and set to UTC.
		Clock clock = Clock.systemUTC();
		System.out.println("Clock : " + clock);
		// output: SystemClock[Z]
		// Returns time based on system clock zone
		Clock defaultClock = Clock.systemDefaultZone();
		System.out.println("Clock : " + defaultClock + "\n");
		// output: SystemClock[America/Guayaquil]

		/** zone */
		ZoneId parisZoneId = ZoneId.of("Europe/Paris");
		LocalDateTime todayDateTime = LocalDateTime.now();
		ZonedDateTime localTimeParis = ZonedDateTime.of(todayDateTime,
				parisZoneId);
		System.out.printf("Time in Paris is: %s %n %n", localTimeParis);

		/** Expire credit card */
		YearMonth yearMonthCard = YearMonth.of(2018, Month.JULY);
		System.out.printf("Your credit card expires on: %s %n %n",
				yearMonthCard);
		// output: Your credit card expires on: 2018-07

		/** check Leap Year */
		if (today.isLeapYear()) {
			System.out.printf("This year is Leap Year(Anio Bisiesto) %s %n %n",
					today.getYear());
		} else {
			System.out.printf(
					"This year is not Leap Year(Anio Bisiesto) %s %n %n",
					today.getYear());
		}

		/** how many ... */
		LocalDate birthMartin = LocalDate.of(2014, Month.NOVEMBER, 21);
		Period periodo = Period.between(birthMartin, today);
		System.out.printf("Martin is %d months, %d days %n %n",
				periodo.getMonths(), periodo.getDays());
		// output: Martin is 4 months, 6 days

		/** SimpleDateFormat was not thread safe */
		String isoFormatDate = "20141121";
		LocalDate dateFormatted = LocalDate.parse(isoFormatDate,
				DateTimeFormatter.BASIC_ISO_DATE);
		System.out.printf("String iso %s is formatted to %s %n %n",
				isoFormatDate, dateFormatted);

		/** Format date */
		LocalDateTime arrriveDate = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter
				.ofPattern("MMMM dd yyyy hh:mm a");
		String finalDateFormatted = arrriveDate.format(format);
		System.out.printf("Arriving at %s %n %n", finalDateFormatted);
		// output: Arriving at marzo 27 2015 12:14 PM
	}

}
