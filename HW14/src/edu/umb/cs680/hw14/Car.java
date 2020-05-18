package edu.umb.cs680.hw14;

import java.util.ArrayList;

public class Car {
	
	private String model, make;
	private int mileage, year,dominationCount;
	private float price;
	
	public Car(String make, String model, int mileage, int year, float price) {
		super();
		this.model = model;
		this.make = make;
		this.mileage = mileage;
		this.year = year;
		this.price = price;
	}
	
	public String getModel() {
		return this.model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMake() {
		return this.make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public int getMileage() {
		return this.mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public int getYear() {
		return this.year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public float getPrice() {
		return this.price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	 public void setDominationCount(ArrayList<Car> cars) {
	        int count = 0;
	        for (Car car : cars) {
	            if (!car.equals(this)) {
	                float price = car.getPrice();
	                int year = car.getYear();
	                int mileage = car.getMileage();

	                if (this.getYear() >= year && this.getMileage() <= mileage && this.getPrice() <= price) {
	                    if (this.getYear() > year || this.getMileage() < mileage || this.getPrice() < price) {
	                        count++;
	                    }
	                }
	            }
	        };
	        this.dominationCount = count;
	    }

	    public int getDominationCount() {
	        return this.dominationCount;
	    }
}