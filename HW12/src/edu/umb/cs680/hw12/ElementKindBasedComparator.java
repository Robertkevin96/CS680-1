package edu.umb.cs680.hw12;

import java.util.Comparator;

public class ElementKindBasedComparator implements Comparator<ApfsElement> {
    public int compare(ApfsElement o1, ApfsElement o2) {
    	
    	// TODO Auto-generated method stub
        // If one of the two elements is directory, place the directory first
        if (o1.isDirectory() && !o2.isDirectory()) {
            return -1;
        }

        if (!o1.isDirectory() && o2.isDirectory()) {
            return 1;
        }

        // If one of the two elements is link, place the other first
        if (o1.isLink() && !o2.isLink()) {
            return 1;
        }

        if (!o1.isLink() && o2.isLink()) {
            return -1;
        }

        return o1.getName().compareTo(o2.getName());
    }
}