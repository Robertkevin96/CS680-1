package edu.umb.cs680.hw10;

import java.time.LocalDateTime;

public abstract class ApfsElement extends FSElement {

	private String ownerName;
	private LocalDateTime lastModified;

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public LocalDateTime getLastModified() {
		return lastModified;
	}

	public void setLastModified(LocalDateTime lastModified) {
		this.lastModified = lastModified;
	}

	public ApfsElement(ApfsDirectory parent, String name, int size, LocalDateTime createdTime, String ownerName,
			LocalDateTime lastModified) {
		super(parent, name, size, createdTime);
		this.ownerName = ownerName;
		this.lastModified = lastModified;
	}

	public abstract boolean isDirectory();

	public abstract void accept(ApfsFSVisitor v);

}
