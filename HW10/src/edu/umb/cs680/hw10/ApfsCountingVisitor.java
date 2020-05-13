package edu.umb.cs680.hw10;

public class ApfsCountingVisitor implements ApfsFSVisitor {
	private int dirNum = 0;
	private int fileNum = 0;
	private int linkNum = 0;

	@Override
	public void visit(ApfsLink link) {
		// TODO Auto-generated method stub
		linkNum++;
	}

	@Override
	public void visit(ApfsDirectory dir) {
		// TODO Auto-generated method stub
		dirNum++;
	}

	public int getDirNum() {
		return dirNum;
	}

	public void setDirNum(int dirNum) {
		this.dirNum = dirNum;
	}

	public int getFileNum() {
		return fileNum;
	}

	public void setFileNum(int fileNum) {
		this.fileNum = fileNum;
	}

	public int getLinkNum() {
		return linkNum;
	}

	public void setLinkNum(int linkNum) {
		this.linkNum = linkNum;
	}

	@Override
	public void visit(ApfsFile file) {
		// TODO Auto-generated method stub
		fileNum++;
	}

}
