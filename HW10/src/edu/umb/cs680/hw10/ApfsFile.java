package edu.umb.cs680.hw10;

import java.time.LocalDateTime;

public class ApfsFile extends ApfsElement {

	public ApfsFile(ApfsDirectory parent, String name, int size, LocalDateTime createdTime, String ownerName,
			LocalDateTime lastModified) {
		super(parent, name, size, createdTime, ownerName, lastModified);
		// TODO Auto-generated constructor stub
		parent.appendChild(this);
	}

	@Override
	public boolean isDirectory() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void accept(ApfsFSVisitor v) {
		// TODO Auto-generated method stub
		 v.visit(this);
	}
	

}
