package edu.umb.cs680.hw13;

import java.util.Observable;
import java.util.Observer;

public class PiechartObserver implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		 if (arg instanceof StockEvent) {
	            String ticker = ((StockEvent) arg).getTicker();
	            Float quote = ((StockEvent) arg).getQuote();
	            System.out.println("(Stock Event)Piechart Observer " + ticker + " " + quote);
	        } else if (arg instanceof DJIAEvent) {
	            Float quote = ((DJIAEvent) arg).getDjia();
	            System.out.println("(DJIA Event) Piechart Observer " + quote);
	        }
	}

}
