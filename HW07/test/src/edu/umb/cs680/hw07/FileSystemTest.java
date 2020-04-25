package edu.umb.cs680.hw07;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw07.Directory;
import edu.umb.cs680.hw07.FileSystem;

class FileSystemTest {
	
	private String[] fileSystemToStringArray(Directory d) {
		String[] dirInfo = { null, d.getName(), Integer.toString(d.getSize()), d.getCreationTime().toString() };
		return dirInfo;
	}
	@Test
	void verifyFileSystem() {
		FileSystem fs1 = FileSystem.getFileSystem();
		FileSystem fs2 = FileSystem.getFileSystem();
		assertSame(fs1, fs2);
	}

	@Test
	void verifyDirectory() {
		LocalDateTime createdTime = LocalDateTime.now();
		Directory root = new Directory(null, "main", 100, createdTime);
		String[] expected = { null, "main", "100", createdTime.toString() };
		FileSystem.getFileSystem().addRootDir(root);
		Directory actual = FileSystem.getFileSystem().getRootDirs().get(0);
		assertArrayEquals(expected, fileSystemToStringArray(actual));
	}

	
}