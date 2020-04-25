package edu.umb.cs680.hw07;

import java.time.LocalDateTime;

import edu.umb.cs680.hw07.Directory;
import edu.umb.cs680.hw07.File;

public abstract class FSElement {
	
	private Directory parent;
	private String name;
	private int size;
	private LocalDateTime creationTime;
	
	public FSElement(Directory parent, String name, int size, LocalDateTime creationTime) {
		
		this.parent = parent;
		this.name = name;
		this.size = size;
		this.creationTime = creationTime;
	}

	public Directory getParent() {
		return this.parent;
	}

	public void setParent(Directory parent) {
		this.parent = parent;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return this.size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public LocalDateTime getCreationTime() {
		return this.creationTime;
	}

	public void setCreationTime(LocalDateTime creationTime) {
		this.creationTime = creationTime;
	}
	
	public abstract boolean isDirectory();	
	
	public static void main(String args[]) {
		Directory root = new Directory(null,"Root", 2, LocalDateTime.now());
		Directory home = new Directory(root, "home", 1,LocalDateTime.now());
		Directory home1 = new Directory(home, "home", 1,LocalDateTime.now());
		
		File file1 = new File(home, "f1",0,LocalDateTime.now());
		File file2 = new File(home, "f2",0,LocalDateTime.now());
		
		System.out.println(home.isDirectory());
		System.out.println(file1.isDirectory());
		System.out.println(home.getTotalSize());
		
	}

}