package edu.umb.cs680.hw13multicast;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MulticastTest {
    private static StockQuoteObservable s;
    private static DJIAQuoteObservable d;
    private static TableObserver table;
    private static PiechartObserver pie;
    private static ThreeDObserver threeD;

    @BeforeAll
    public static void setUp() {
        s = new StockQuoteObservable();
        d = new DJIAQuoteObservable();

        table = new TableObserver();
        pie = new PiechartObserver();
        threeD = new ThreeDObserver();

        s.addObserver(table);
        s.addObserver(pie);
        s.addObserver(threeD);

        d.addObserver(table);
        d.addObserver(pie);
        d.addObserver(threeD);
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
        s.notifyObservers(new StockEvent("LYFT", 28.05f));
        s.notifyObservers(new StockEvent("UBER", 32.42f));
        s.notifyObservers(new StockEvent("LYFT", 35.06f));
        s.notifyObservers(new StockEvent("UBER", 40.06f));
        s.notifyObservers(new StockEvent("LYFT", 45.06f));
        s.notifyObservers(new StockEvent("UBER", 50.06f));


        int expectedNumObservers = 3;
        int actualNumObservers = s.countObservers();
        assertEquals(expectedNumObservers, actualNumObservers);
    }

    @Test
    public void changeDJIAQuote() {
        d.notifyObservers(new DJIAEvent(18.65f));
        d.notifyObservers(new DJIAEvent(28.65f));
        d.notifyObservers(new DJIAEvent(38.65f));
        d.notifyObservers(new DJIAEvent(48.65f));
        d.notifyObservers(new DJIAEvent(58.65f));
        d.notifyObservers(new DJIAEvent(68.65f));

        int expectedNumObservers = 3;
        int actualNumObservers = d.countObservers();
        assertEquals(expectedNumObservers, actualNumObservers);
    }


}
