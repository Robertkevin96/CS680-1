package edu.umb.cs680.hw10;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class ApfsDirectory extends ApfsElement {
	private LinkedList<ApfsElement> child;

	public ApfsDirectory(ApfsDirectory parent, String name, int size, LocalDateTime createdTime, String ownerName,
			LocalDateTime lastModified) {
		super(parent, name, size, createdTime, ownerName, lastModified);
		// TODO Auto-generated constructor stub
		if (parent != null)
			parent.appendChild(this);
	}

	@Override
	public boolean isDirectory() {
		// TODO Auto-generated method stub
		return true;
	}

	public LinkedList<ApfsElement> getChildren() {
		if (this.child == null) {
			this.child = new LinkedList<ApfsElement>();
		}
		return child;
	}

	public ApfsLink findLinkByName(String linkName) {
		ApfsLink link = null;
		for (ApfsLink l : getLinks()) {
			if (linkName.equals(l.getName()))
				link = l;
		}
		if (link == null) {
			for (ApfsDirectory dir : getSubDirectories()) {
				link = dir.findLinkByName(linkName);
				if (link != null)
					break;
			}
		}
		return link;
	}

	public LinkedList<ApfsLink> getLinks() {
		LinkedList<ApfsLink> linkList = new LinkedList<ApfsLink>();
		for (FSElement element : getChildren()) {
			if (element instanceof ApfsLink)
				linkList.add((ApfsLink) element);
		}
		return linkList;
	}

	public int countChildren() {
		return getChildren().size() - getLinks().size();
	}

	public void appendChild(ApfsElement child) {
		if (this.child == null) {
			this.child = new LinkedList<ApfsElement>();
		}
		this.child.add(child);
	}

	public ApfsFile findFileByName(String fName) {
		ApfsFile file = null;
		for (ApfsFile f : getFiles()) {
			if (fName.equals(f.getName()))
				file = f;
		}
		if (file == null) {
			for (ApfsDirectory dir : getSubDirectories()) {
				file = dir.findFileByName(fName);
				if (file != null)
					break;
			}
		}
		return file;
	}

	public ApfsDirectory findDirByName(String dName) {
		ApfsDirectory directory = null;
		if (dName.equals(getName()))
			directory = this;
		else {
			for (ApfsDirectory dir : getSubDirectories()) {
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

	public int getTotalSize() {
		int totalSize = 0;
		for (ApfsElement element : getChildren()) {
			if (element instanceof ApfsDirectory)
				totalSize += ((ApfsDirectory) element).getTotalSize();
			else
				totalSize += element.getSize();
		}
		return totalSize;
	}

	public LinkedList<ApfsFile> getFiles() {
		LinkedList<ApfsFile> fList = new LinkedList<ApfsFile>();
		for (FSElement element : getChildren()) {
			if (element instanceof ApfsFile)
				fList.add((ApfsFile) element);
		}
		return fList;
	}

	public LinkedList<ApfsDirectory> getSubDirectories() {
		LinkedList<ApfsDirectory> dList = new LinkedList<ApfsDirectory>();
		for (FSElement element : getChildren()) {
			if (element instanceof ApfsDirectory)
				dList.add((ApfsDirectory) element);
		}
		return dList;
	}

	@Override
	public void accept(ApfsFSVisitor v) {
		// TODO Auto-generated method stub
		 v.visit(this);
	        for (ApfsElement e : this.child) {
	            e.accept(v);
	        }
	}

}
