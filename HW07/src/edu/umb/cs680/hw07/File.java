package edu.umb.cs680.hw07;

import java.time.LocalDateTime;

public class File extends FSElement {

	public File(Directory parent, String name, int size, LocalDateTime creationTime) {
		super(parent, name, size, creationTime);
		// TODO Auto-generated constructor stub
		parent.appendChild(this);
	}

	@Override
	public boolean isDirectory() {
		// TODO Auto-generated method stub
		return false;
	}

}
