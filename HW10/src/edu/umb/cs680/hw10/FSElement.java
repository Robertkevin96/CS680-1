package edu.umb.cs680.hw10;

import java.time.LocalDateTime;

public abstract class FSElement {
	private String name;
	private int size;
	private LocalDateTime creationTime;
	private ApfsDirectory parent;
	
	public FSElement(ApfsDirectory parent, String name, int size, LocalDateTime creationTime) {
		this.parent = parent;
		this.name = name;
		this.size = size;
		this.creationTime = creationTime;
	}

	public abstract boolean isDirectory();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public LocalDateTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(LocalDateTime createdTime) {
		this.creationTime = createdTime;
	}

	public ApfsDirectory getParent() {
		return parent;
	}

	public void setParent(ApfsDirectory parent) {
		this.parent = parent;
	}


}
