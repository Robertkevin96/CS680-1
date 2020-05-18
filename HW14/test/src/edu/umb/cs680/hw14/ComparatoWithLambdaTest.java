package edu.umb.cs680.hw14;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ComparatoWithLambdaTest {
	private String[] carsToStringArray(ArrayList<Car> cars) {
		String[] carsMake = new String[cars.size()];
		for (int i = 0; i < cars.size(); i++) {
			carsMake[i] = cars.get(i).getMake();
		}
		return carsMake;
	}

	private static ArrayList<Car> cars = new ArrayList<>();;

	@BeforeAll
	public static void setUp() {
		cars.add(new Car("Tata", "Nano", 20, 2015, 2000));
		cars.add(new Car("Tesla", "3", 0, 2020, 5000000));
		cars.add(new Car("BMW", "Q5", 10, 2018, 20000));
		cars.add(new Car("Mercedes", "Benz", 16, 2019, 3000000));

	}

	// Price Ascending
	@Test
	public void comparePrice() {
		String[] expected = { "Tata", "BMW", "Mercedes", "Tesla" };
		Collections.sort(cars, Comparator.comparing(Car::getPrice));
		String[] actual = carsToStringArray(cars);
		assertArrayEquals(expected, actual);
	}

	// Price Descending
	@Test
	public void comparePriceReverseOrder() {
		String[] expected = { "Tesla", "Mercedes", "BMW", "Tata" };
		Collections.sort(cars, Comparator.comparing(Car::getPrice, Comparator.reverseOrder()));
		String[] actual = carsToStringArray(cars);
		assertArrayEquals(expected, actual);
	}

	// Year Ascending
	@Test
	public void compareYear() {
		String[] expected = { "Tata", "BMW", "Mercedes", "Tesla" };
		Collections.sort(cars, Comparator.comparing(Car::getYear));
		String[] actual = carsToStringArray(cars);
		assertArrayEquals(expected, actual);
	}

	// Year Descending
	@Test
	public void compareYearReverseOrder() {
		String[] expected = { "Tesla", "Mercedes", "BMW", "Tata" };
		Collections.sort(cars, Comparator.comparing(Car::getYear, Comparator.reverseOrder()));
		String[] actual = carsToStringArray(cars);
		assertArrayEquals(expected, actual);
	}

	// Millage Ascending
	@Test
	public void compareMileage() {
		String[] expected = { "Tesla", "BMW", "Mercedes", "Tata" };
		Collections.sort(cars, Comparator.comparing((Car car) -> car.getMileage()));
		String[] actual = carsToStringArray(cars);
		for (String s : actual)
			// System.out.println(s);
			assertArrayEquals(expected, actual);
	}

	// Millage Descending
	@Test
	public void compareMileageReverseOrder() {
		String[] expected = { "Tata", "Mercedes", "BMW", "Tesla" };
		Collections.sort(cars, Comparator.comparing((Car car) -> car.getMileage(), Comparator.reverseOrder()));
		String[] actual = carsToStringArray(cars);
		for (String s : actual)
			// System.out.println(s);
			assertArrayEquals(expected, actual);
	}

	// PareTo Ascending

		@Test
		public void comparePareTo() {
			for (Car car : cars) {
				car.setDominationCount(cars);
			}

			String[] expected = {"Tesla", "Mercedes", "BMW", "Tata"};
			
			Collections.sort(cars, Comparator.comparing((Car car) -> car.getDominationCount()));
			String[] actual = carsToStringArray(cars);
			assertArrayEquals(expected, actual);
		}
		// PareTo Descending
	
	  @Test public void comparePareToReverseOrder() { for (Car car : cars) {
	  car.setDominationCount(cars); }
	  
	  String[] expected = { "Tata", "Mercedes", "BMW", "Tesla" };
	  Collections.sort(cars, Comparator.comparing((Car car) ->
	  car.getDominationCount(), Comparator.reverseOrder())); String[] actual =
	  carsToStringArray(cars); assertArrayEquals(expected, actual); }
	 
}
