package edu.umb.cs680.hw08;

import java.util.LinkedList;

public class FileSystem {
	private FileSystem() {};
	
	private LinkedList<Directory> directoryRoot;
	private static FileSystem instance = null;
	
	
	public static FileSystem getFileSystem() {
		if(instance==null) 
			instance = new FileSystem ();
		return instance;  
	}
	//for testing purpose
	public void addRootDir(Directory dir) {
		directoryRoot = new LinkedList<Directory>();
		directoryRoot.add(dir);
	}
	public LinkedList<Directory> getRootDirs() {
		return this.directoryRoot;
	}
}
