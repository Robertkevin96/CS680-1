package edu.umb.cs680.hw13;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class StockQuoteObservable extends Observable{
	
	 private Map<String,Float> ticker_quote = new HashMap<>();
	 public void changeQuote(String t, Float q) {
	        ticker_quote.put(t, q);
	        setChanged();
	        notifyObservers(new StockEvent(t,q));
	    }
}
