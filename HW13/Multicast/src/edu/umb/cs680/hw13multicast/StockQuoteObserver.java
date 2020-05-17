package edu.umb.cs680.hw13multicast;

public interface StockQuoteObserver {
    void updateStock(StockEvent e);
}
