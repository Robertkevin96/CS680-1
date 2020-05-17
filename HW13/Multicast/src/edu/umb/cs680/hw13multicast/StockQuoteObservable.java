package edu.umb.cs680.hw13multicast;

import java.util.ArrayList;
import java.util.List;

public class StockQuoteObservable {
    private List<StockQuoteObserver> observers;

    StockQuoteObservable() {
        observers = new ArrayList<>();
    }

    public void addObserver(StockQuoteObserver ob) {
        observers.add(ob);
    }

    public void notifyObservers(StockEvent e) {
        observers.forEach(observer -> observer.updateStock(e));
    }

    public int countObservers() {
        return observers.size();
    }
}
