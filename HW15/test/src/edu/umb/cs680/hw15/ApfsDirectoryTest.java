package edu.umb.cs680.hw15;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw15.APFS;
import edu.umb.cs680.hw15.ApfsDirectory;
import edu.umb.cs680.hw15.ApfsFile;
import edu.umb.cs680.hw15.ApfsLink;

public class ApfsDirectoryTest {
static LocalDateTime localTime = LocalDateTime.of(2020, 06, 12, 0, 0);
	
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
	
	private String[] dirToStringArray(ApfsDirectory d) {
		Optional<ApfsDirectory> optDirectory = Optional.ofNullable(d.getParent());
		String[] dirInfo = { Boolean.toString(d.isDirectory()), d.getName(), Integer.toString(d.getSize()),
				d.getCreationTime().toString(), optDirectory.isPresent() ? d.getParent().getName() : null,
				Integer.toString(d.getTotalSize()), Integer.toString(d.countChildren()), d.getOwnerName(),
				d.getLastModified().toString() };
		return dirInfo;
	}
	
	
	@Test
	public void verifyDirectoryEqualityRoot() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) ApfsFileSystem.getRootDirectory();
		String[] expected = { "true", "root", "0", localTime.toString(), null, "600", "2", "yash",
				localTime.toString() };
		ApfsDirectory actual = root.findDirByName("root");
		assertArrayEquals(expected, dirToStringArray(actual));
	}

	@Test
	public void verifyDirectoryEqualityHome() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) ApfsFileSystem.getRootDirectory();
		String[] expected = { "true", "home", "0", localTime.toString(), "root", "400", "3", "yash",
				localTime.toString() };
		ApfsDirectory actual = root.findDirByName("home");
		assertArrayEquals(expected, dirToStringArray(actual));
	}

	@Test
	public void verifyDirectoryEqualityApplications() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) ApfsFileSystem.getRootDirectory();
		String[] expected = { "true", "applications", "0", localTime.toString(), "root", "200", "2", "yash",
				localTime.toString() };
		ApfsDirectory actual = root.findDirByName("applications");
		assertArrayEquals(expected, dirToStringArray(actual));
	}

	@Test
	public void verifyDirectoryEqualityCode() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) ApfsFileSystem.getRootDirectory();
		String[] expected = { "true", "code", "0", localTime.toString(), "home", "200", "2", "yash",
				localTime.toString() };
		ApfsDirectory actual = root.findDirByName("code");
		assertArrayEquals(expected, dirToStringArray(actual));
	}
	
	@Test
	void verifyDirectory() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) ApfsFileSystem.getRootDirectory();
		assertTrue(root.findDirByName("root").isDirectory());
		assertTrue(root.findDirByName("home").isDirectory());
		assertTrue(root.findDirByName("applications").isDirectory());
		assertTrue(root.findDirByName("code").isDirectory());
	}
	
	@Test
	void verifyDirectoryName() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) ApfsFileSystem.getRootDirectory();
		assertSame("home", root.findDirByName("home").getName());
		assertSame("root", root.findDirByName("root").getName());
		assertSame("applications", root.findDirByName("applications").getName());
		assertSame("code", root.findDirByName("code").getName());
		
	}
	
	@Test
	void checkSize() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) ApfsFileSystem.getRootDirectory();
		assertEquals(600, root.findDirByName("root").getTotalSize());
		assertEquals(400, root.findDirByName("home").getTotalSize());
		assertEquals(200, root.findDirByName("applications").getTotalSize());
		assertEquals(200, root.findDirByName("code").getTotalSize());
	}
	
	@Test
	void verifyFilesInDirectory() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) ApfsFileSystem.getRootDirectory();
		assertSame("a", root.findDirByName("applications").getFiles().get(0).getName());
		assertSame("b", root.findDirByName("applications").getFiles().get(1).getName());
		assertSame("c", root.findDirByName("home").getFiles().get(0).getName());
		assertSame("d", root.findDirByName("home").getFiles().get(1).getName());
		assertSame("e", root.findDirByName("code").getFiles().get(0).getName());
		assertSame("f", root.findDirByName("code").getFiles().get(1).getName());
	}
	
	@Test
	void verifySubDirectories() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) ApfsFileSystem.getRootDirectory();
		assertSame("applications", root.findDirByName("root").getSubDirectories().get(0).getName());
		assertSame("home", root.findDirByName("root").getSubDirectories().get(1).getName());
		assertSame("code", root.findDirByName("home").getSubDirectories().get(0).getName());
	}

	@Test
	void verfiyCount() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) ApfsFileSystem.getRootDirectory();
		assertEquals(2, root.findDirByName("root").countChildren());
		assertEquals(2, root.findDirByName("applications").countChildren());
		assertEquals(3, root.findDirByName("home").countChildren());
		assertEquals(2, root.findDirByName("code").countChildren());
	}
	
}
