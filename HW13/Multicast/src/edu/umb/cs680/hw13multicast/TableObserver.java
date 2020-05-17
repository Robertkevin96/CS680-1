package edu.umb.cs680.hw13multicast;

public class TableObserver implements DJIAQuoteObserver, StockQuoteObserver {
	@Override
	public void updateDJIA(DJIAEvent e) {
		System.out.println("(DJIA Event) Piechart Observer " + e.getDjia());
	}

	@Override
	public void updateStock(StockEvent e) {
		System.out.println("(Stock Event)Piechart Observer " + e.getTicker() + " " + e.getQuote());
	}
}
