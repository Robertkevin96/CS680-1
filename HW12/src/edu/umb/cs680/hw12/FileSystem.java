package edu.umb.cs680.hw12;

public abstract class FileSystem {
	
	private String fileSystemName;
	private int capacity;
	private int id;
	private FSElement rootDirectory;
	
	protected abstract FSElement createDefaultRoot();
	
	public FSElement initFileSystem(String name, int capacity) {
		this.fileSystemName = name;
		this.capacity = capacity;
		FSElement root = createDefaultRoot();
		if (root.isDirectory() && capacity > root.getSize()) {
			setRootDirectory(root);
			this.id = root.hashCode();
			return root;
		} else
			return null;
	}
	
	
	public String getFileSystemName() {
		return fileSystemName;
	}

	public void setFileSystemName(String fileSystemName) {
		this.fileSystemName = fileSystemName;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public FSElement getRootDirectory() {
		return rootDirectory;
	}

	public void setRootDirectory(FSElement rootDirectory) {
		this.rootDirectory = rootDirectory;
	}

	

}
