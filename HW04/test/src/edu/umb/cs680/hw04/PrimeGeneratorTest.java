package edu.umb.cs680.hw04;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw04.PrimeGenerator;

	
	
public class PrimeGeneratorTest {
	
	@Test
	public void primeGenerator1to10() {
		PrimeGenerator gen = new PrimeGenerator(1, 10);
		gen.generatePrimes();
		Long[] expectedPrimes = {2L, 3L, 5L, 7L};
		assertArrayEquals( expectedPrimes, gen.getPrimes().toArray() );
	}
	
	@Test
	public void primeGenerator40to50() {
		PrimeGenerator gen = new PrimeGenerator(40, 50);
		gen.generatePrimes();
		Long[] expectedPrimes = {41L, 43L, 47L};
		assertArrayEquals( expectedPrimes, gen.getPrimes().toArray() );
	}
	
	@Test
	public void primeGenerator10to10() {
		long from = 10;// implicit type casting int to long
		long to = 10;
			try{
				
				PrimeGenerator gen = new PrimeGenerator(from, to);
				gen.generatePrimes();
				Long[] expectedPrimes = {};
				assertArrayEquals( expectedPrimes, gen.getPrimes().toArray() );
			}
			catch(RuntimeException ex){
				assertEquals("Wrong input values: from=" + from + " to=" + to,ex.getMessage());
				//System.out.println(ex.getMessage());
			}
		
	}
	
	@Test
	public void primeGeneratornegative10to10() {
		long from = -10;
		long to = 10;
			try{
				
				PrimeGenerator gen = new PrimeGenerator(from, to);
				gen.generatePrimes();
				Long[] expectedPrimes = {};
				assertArrayEquals( expectedPrimes, gen.getPrimes().toArray() );
			}
			catch(RuntimeException ex){
				assertEquals("Wrong input values: from=" + from + " to=" + to,ex.getMessage());
				//System.out.println(ex.getMessage());
			}
		
	}
	
	
	@Test
	public void primeGenerator100to1() {
		long from = 100; // implicit type casting int to long
		long to = 1;
			try{
				
				PrimeGenerator gen = new PrimeGenerator(from, to);
				gen.generatePrimes();
				Long[] expectedPrimes = {};
				assertArrayEquals( expectedPrimes, gen.getPrimes().toArray() );
			}
			catch(RuntimeException ex){
				assertEquals("Wrong input values: from=" + from + " to=" + to,ex.getMessage());
				//System.out.println(ex.getMessage());
			}
		
	}

}
