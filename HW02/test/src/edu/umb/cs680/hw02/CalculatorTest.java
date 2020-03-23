package edu.umb.cs680.hw02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw02.Calculator;



 class CalculatorTest {
	
	
	
	@Test
	   public void Multiply_6And4() throws Exception{
			Calculator calculator = new Calculator();
			double number = calculator.Multiply(6, 4);
			assertEquals(24, number);
		}
	
	
	@Test
	   public void Multiply_0And0() throws Exception{
			Calculator calculator = new Calculator();
			double number = calculator.Multiply(0, 0);
			assertEquals(0, number);
		}
	
	@Test
	   public void Multiply_MinusAndMinus() throws Exception{
			Calculator calculator = new Calculator();
			double number = calculator.Multiply(-2, -7);
			assertEquals(14, number);
		}
	
	
	@Test
	   public void Division_6And3() throws Exception{
			Calculator calculator = new Calculator();
			double number = calculator.Division(6, 3);
			assertEquals(2, number);
			
		}
	
	@Test
	   public void Division_MinusAndMinus() throws Exception{
			Calculator calculator = new Calculator();
			double number = calculator.Division(-4, -2);
			assertEquals(2, number);
			
		}
	
	@Test
	   public void Division_MinusAndPositive() throws Exception{
			Calculator calculator = new Calculator();
			double number = calculator.Division(-6, 3);
			assertEquals(-2, number);
			
		}
	
	
	@Test
	   public void Division_8By0() throws Exception{
		    Calculator calculator = new Calculator();
		    try {
		    	calculator.Division(8, 0);
			    fail("Undefined!!");
			    } catch (IllegalArgumentException ex) {
			    	assertEquals("Undefined!!", ex.getMessage());		
		}
	}
}
