package edu.umb.cs680.hw01;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
public class CalculatorTest{
	
	@Test
	public void multiply3By4() {
		Calculator cut = new Calculator();
		float expected = 12;
		float actual = cut.multiply(3, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	public void divide3By2()
	{
		Calculator cut = new Calculator();
		float expected = 1.5f;
		float actual = cut.divide(3, 2);
		assertEquals(expected, actual);
	}
	
	@Test
	public void sub3by2()
	{
		Calculator cut = new Calculator();
		float expected = 1f;
		float actual = cut.sub(3, 2);
		assertEquals(expected, actual);
	}
	
	@Test
	public void add3by2()
	{
		Calculator cut = new Calculator();
		float expected = 5f;
		float actual = cut.add(3, 2);
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void sub2by5(){
	Calculator cut = new Calculator();
		try{
			cut.sub(2, 5);
			fail("X < Y");
		}
		catch(IllegalArgumentException ex){
			assertEquals("X < Y",ex.getMessage());
		}
	}
		
	@Test
	public void divide5By0(){
	Calculator cut = new Calculator();
		try{
			cut.divide(5, 0);
			fail("Division by zero");
		}
		catch(IllegalArgumentException ex){
			assertEquals("Division By Zero",ex.getMessage());
			//System.out.println(ex.getMessage());
		}
	}
}