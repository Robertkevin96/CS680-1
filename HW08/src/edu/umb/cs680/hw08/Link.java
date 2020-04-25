package edu.umb.cs680.hw08;

import java.time.LocalDateTime;

public class Link extends FSElement {
	private FSElement target;
	
	public Link(Directory parent, String name, int size, LocalDateTime creationTime,  FSElement target) {
		super(parent, name, size, creationTime);
		// TODO Auto-generated constructor stub
		this.target = target;
		parent.appendChild(this);
	}

	public FSElement getTarget() {
		return this.target;
	}

	public void setTarget(FSElement target) {
		this.target = target;
	}

	@Override
	public boolean isDirectory() {
		// TODO Auto-generated method stub
		return false;
	}

}
