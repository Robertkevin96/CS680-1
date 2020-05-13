package edu.umb.cs680.hw10;

import java.util.LinkedList;

public class ApfsFileSearchVisitor implements ApfsFSVisitor {
	private String fileName;
	private LinkedList<ApfsFile> foundFiles = new LinkedList<>();

	public ApfsFileSearchVisitor(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void visit(ApfsLink link) {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public void visit(ApfsDirectory dir) {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public void visit(ApfsFile file) {
		// TODO Auto-generated method stub
		if (file.getName().equals(this.fileName)) {
			foundFiles.add(file);
		}
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public LinkedList<ApfsFile> getFoundFiles() {
		return foundFiles;
	}

	public void setFoundFiles(LinkedList<ApfsFile> foundFiles) {
		this.foundFiles = foundFiles;
	}

}
