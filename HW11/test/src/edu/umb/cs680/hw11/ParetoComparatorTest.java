package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ParetoComparatorTest {
	 private String[] carsToStringArray(ArrayList<Car> cars) {
	        String[] carsMake =  new String[cars.size()];
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

	   
	    @Test
	    public void comparePareto() {
	        for (Car car : cars) {
	            car.setDominationCount(cars);
	        }

	        String[] expected = {"Tata", "Tesla", "BMW", "Mercedes"};
	        Collections.sort(cars, new ParetoComparator());
	        String[] actual = carsToStringArray(cars);
	        assertArrayEquals(expected, actual);
	    }

	  
}
