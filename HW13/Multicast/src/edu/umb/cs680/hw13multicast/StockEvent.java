package edu.umb.cs680.hw13multicast;

public class StockEvent {
    private String ticker;
    private Float quote;
	public StockEvent(String ticker, Float quote) {
		super();
		this.ticker = ticker;
		this.quote = quote;
	}
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public Float getQuote() {
		return quote;
	}
	public void setQuote(Float quote) {
		this.quote = quote;
	}

   
}
