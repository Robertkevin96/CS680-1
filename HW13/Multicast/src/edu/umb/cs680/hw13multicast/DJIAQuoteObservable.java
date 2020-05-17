package edu.umb.cs680.hw13multicast;

import java.util.ArrayList;
import java.util.List;

public class DJIAQuoteObservable {
    private List<DJIAQuoteObserver> observers;

    DJIAQuoteObservable() {
        observers = new ArrayList<>();
    }

    public void addObserver(DJIAQuoteObserver ob) {
        observers.add(ob);
    }

    public void notifyObservers(DJIAEvent e) {
        observers.forEach(observer -> observer.updateDJIA(e));
    }

    public int countObservers() {
        return observers.size();
    }
}