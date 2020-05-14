package edu.umb.cs680.hw11;

import java.util.Comparator;

public class YearComparator implements Comparator<Car> {

	@Override
	public int compare(Car o1, Car o2) {
		// TODO Auto-generated method stub
		 return o2.getYear() - o1.getYear();
	}

}
