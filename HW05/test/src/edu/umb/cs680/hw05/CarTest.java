package edu.umb.cs680.hw05;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.Test;

public class CarTest {
	private String[] CarToStringArray(Car c){
		String[] carInfo = 
			{ 
				c.getMake(), c.getModel(), Integer.toString(c.getYear()) 
			};
		return carInfo;
	}	
	
	
	@Test
	public void verifyCarEqualityWithMakeModelYear() {
		String[] expected = {"Toyota", "RAV4", "2019"};
		Car actual = new Car("Toyota", "RAV4",28, 2019, 23000);
		assertArrayEquals(expected, CarToStringArray(actual));
	}
	
	@Test
	public void verifyCarEqualityWithMakeModelYear_NotEqual() {
		String[] expected = {"Ford", "RAV5", "2019"};
		Car actual = new Car("Toyota", "RAV5", 28, 2019, 23000);
		assertNotEquals(expected, CarToStringArray(actual));
	}	

}
