package edu.umb.cs680.hw13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;

public class ObservableTest {

	static StockQuoteObservable s = new StockQuoteObservable();
	static DJIAQuoteObservable d = new DJIAQuoteObservable();

	@BeforeAll
	public static void setUp() {

		s.addObserver(new PiechartObserver());
		s.addObserver(new TableObserver());
		s.addObserver(new ThreeDObserver());

		d.addObserver(new PiechartObserver());
		d.addObserver(new TableObserver());
		d.addObserver(new ThreeDObserver());

	}

	@Test
	public void numberOfStockQuoteObservers() {

		int expectedNumObservers = 3;
		int actualNumObservers = s.countObservers();
		assertEquals(expectedNumObservers, actualNumObservers);

	}

	@Test
	public void numberOfDJIAQuotObservers() {

		int expectedNumObservers = 3;
		int actualNumObservers = s.countObservers();
		assertEquals(expectedNumObservers, actualNumObservers);

	}

	@Test
	public void changeStockQuote() {

		s.changeQuote("LYFT", 28.05f);
		s.changeQuote("UBER", 32.42f);
		s.changeQuote("LYFT", 35.06f);
		s.changeQuote("UBER", 40.06f);
		s.changeQuote("LYFT", 45.06f);
		s.changeQuote("UBER", 50.06f);

		int expectedNumObservers = 3;
		int actualNumObservers = s.countObservers();
		assertEquals(expectedNumObservers, actualNumObservers);
	}

	@Test
	public void changeDJIAQuote() {

		d.changeQuote(18.65f);
		d.changeQuote(20.45f);
		d.changeQuote(32.33f);
		d.changeQuote(28.65f);
		d.changeQuote(30.45f);
		d.changeQuote(42.33f);

		int expectedNumObservers = 3;
		int actualNumObservers = d.countObservers();
		assertEquals(expectedNumObservers, actualNumObservers);
	}

}
