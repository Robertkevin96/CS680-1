package edu.umb.cs680.hw08;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement {
	
	private LinkedList<FSElement> child;

	public Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
		
		// TODO Auto-generated constructor stub
		
		super(parent, name, size, creationTime);
		if (parent != null)
			parent.appendChild(this);
		
	}

	@Override
	public boolean isDirectory() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public LinkedList<FSElement> getChildren() {
		return child;
	}
	public void appendChild(FSElement child) {
		if(this.child == null) {
			this.child = new LinkedList<FSElement>();
		}	
		this.child.add(child);
	}
	public int countChildren() {
		return getChildren().size();
	}
	public LinkedList<Directory> getSubDirectories() {
		LinkedList<Directory> listDirectories = new LinkedList<Directory>();
		for(FSElement s : getChildren()) {
			if(s instanceof Directory)
				listDirectories.add((Directory) s);
		}
		return listDirectories;	
	}
	public LinkedList<File> getFiles() {
		LinkedList<File> listfile = new LinkedList<File>();
		for(FSElement s : getChildren()) {
			if(s instanceof File)
				listfile.add((File)s);
		}
		return listfile;
	}
	public int getTotalSize() {
		int totalSize = 0;
		for(FSElement e : getChildren()) {
			if(e instanceof Directory)
				totalSize += ((Directory) e).getTotalSize();
			else
				totalSize += e.getSize();
		}
		return totalSize;
	}
	//for testing purpose
	public File findFileByName(String fName) {
		File file = null;
		for (File f : getFiles()) {
			if (fName.equals(f.getName()))
				file = f;
		}
		if (file == null) {
			for (Directory dir : getSubDirectories()) {
				file = dir.findFileByName(fName);
				if (file != null)
					break;
			}
		}
		return file;
	}
	//for testing purpose added
	public Directory findDirByName(String dName) {
		Directory directory = null;
		if (dName.equals(getName()))
			directory = this;
		else {
			for (Directory dir : getSubDirectories()) {
				if (directory == null) {
					directory = dir.findDirByName(dName);
					if (dName.equals(dir.getName())) {
						directory = dir;
						break;
					}
				}
			}
		}
		return directory;
	}
	
	//for testing purpose added
	public Link findLinkByName(String linkName) {
		Link link = null;
		for (Link l : getLinks()) {
			if (linkName.equals(l.getName()))
				link = l;
		}
		if (link == null) {
			for (Directory dir : getSubDirectories()) {
				link = dir.findLinkByName(linkName);
				if (link != null)
					break;
			}
		}
		return link;
	}

	public LinkedList<Link> getLinks() {
		LinkedList<Link> linkList = new LinkedList<Link>();
		for (FSElement element : getChildren()) {
			if (element instanceof Link)
				linkList.add((Link) element);
		}
		return linkList;
	}

}
