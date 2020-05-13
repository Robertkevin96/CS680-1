package edu.umb.cs680.hw10;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw10.APFS;
import edu.umb.cs680.hw10.ApfsDirectory;
import edu.umb.cs680.hw10.ApfsFile;
import edu.umb.cs680.hw10.ApfsLink;


public class ApfsFileTest {
	

	static LocalDateTime localTime = LocalDateTime.now();
	
	@BeforeAll
	public static void initialize() {

		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) ApfsFileSystem.initFileSystem("yashmahant", 5000);
		ApfsDirectory applications = new ApfsDirectory(root, "applications", 0, localTime, "yash", localTime);
		ApfsDirectory home = new ApfsDirectory(root, "home", 0, localTime, "yash", localTime);
		ApfsDirectory code = new ApfsDirectory(home, "code", 0, localTime, "yash", localTime);
		ApfsFile a = new ApfsFile(applications, "a", 100, localTime, "yash", localTime);
		ApfsFile b = new ApfsFile(applications, "b", 100, localTime, "yash", localTime);
		ApfsFile c = new ApfsFile(home, "c", 100, localTime, "yash", localTime);
		ApfsFile d = new ApfsFile(home, "d", 100, localTime, "yash", localTime);
		ApfsFile e = new ApfsFile(code, "e", 100, localTime, "yash", localTime);
		ApfsFile f = new ApfsFile(code, "f", 100, localTime, "guest", localTime);
		ApfsLink x = new ApfsLink(home, "x", 0, localTime, "yash", localTime, applications);
		ApfsLink y = new ApfsLink(code, "y", 0, localTime, "yash", localTime, b);
	}

	
	private String[] fileToStringArray(ApfsFile f) {
		Optional<ApfsDirectory> optDirectory = Optional.ofNullable(f.getParent());
		String[] fInformation = { Boolean.toString(f.isDirectory()), f.getName(), Integer.toString(f.getSize()),
				f.getCreationTime().toString(), optDirectory.isPresent() ? f.getParent().getName() : null,
				f.getOwnerName(), f.getLastModified().toString() };
		return fInformation;
	}

	
	@Test
	public void verifyFileA() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) ApfsFileSystem.getRootDirectory();
		String[] expected = { "false", "a", "100", localTime.toString(), "applications", "yash",
				localTime.toString() };
		ApfsFile actual = root.findFileByName("a");
		assertArrayEquals(expected, fileToStringArray(actual));
	}
	
	@Test
	public void verifyFileB() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) ApfsFileSystem.getRootDirectory();
		String[] expected = { "false", "b", "100", localTime.toString(), "applications", "yash",
				localTime.toString() };
		ApfsFile actual = root.findFileByName("b");
		assertArrayEquals(expected, fileToStringArray(actual));
	}

	@Test
	public void verifyFileC() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) ApfsFileSystem.getRootDirectory();
		String[] expected = { "false", "c", "100", localTime.toString(), "home", "yash",
				localTime.toString() };
		ApfsFile actual = root.findFileByName("c");
		assertArrayEquals(expected, fileToStringArray(actual));
	}
	
	@Test
	public void verifyFileD() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) ApfsFileSystem.getRootDirectory();
		String[] expected = { "false", "d", "100", localTime.toString(), "home", "yash",
				localTime.toString() };
		ApfsFile actual = root.findFileByName("d");
		assertArrayEquals(expected, fileToStringArray(actual));
	}

	@Test
	public void verifyFileE() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) ApfsFileSystem.getRootDirectory();
		String[] expected = { "false", "e", "100", localTime.toString(), "code", "yash", localTime.toString() };
		ApfsFile actual = root.findFileByName("e");
		assertArrayEquals(expected, fileToStringArray(actual));
	}
	
	@Test
	public void verifyFileF() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) ApfsFileSystem.getRootDirectory();
		String[] expected = { "false", "f", "100", localTime.toString(), "code", "guest", localTime.toString() };
		ApfsFile actual = root.findFileByName("f");
		assertArrayEquals(expected, fileToStringArray(actual));
	}
	@Test
	void verifyIsNotDirectory() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) ApfsFileSystem.getRootDirectory();
		assertFalse(root.findFileByName("a").isDirectory());
		assertFalse(root.findFileByName("b").isDirectory());
		assertFalse(root.findFileByName("c").isDirectory());
		assertFalse(root.findFileByName("d").isDirectory());
		assertFalse(root.findFileByName("e").isDirectory());
		assertFalse(root.findFileByName("f").isDirectory());
	}
	@Test
	void verifyFilesName() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) ApfsFileSystem.getRootDirectory();
		assertSame("a", root.findDirByName("applications").getFiles().get(0).getName());
		assertSame("b", root.findDirByName("applications").getFiles().get(1).getName());
		assertSame("c", root.findDirByName("home").getFiles().get(0).getName());
		assertSame("d", root.findDirByName("home").getFiles().get(1).getName());
		assertSame("e", root.findDirByName("code").getFiles().get(0).getName());
		assertSame("f", root.findDirByName("code").getFiles().get(1).getName());
	}
	
	
}
