package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw08.Directory;
import edu.umb.cs680.hw08.File;
import edu.umb.cs680.hw08.FileSystem;

class DirectoryTest {

	static LocalDateTime localTime = LocalDateTime.now();

	
	@BeforeAll
	public static void initialize() {
		Directory root = new Directory(null, "root", 0, localTime);
		Directory applications = new Directory(root, "applications", 0, localTime);
		Directory home = new Directory(root, "home", 0, localTime);
		Directory code = new Directory(home, "code", 0, localTime);
		File a = new File(applications, "a", 100, localTime);
		File b = new File(applications, "b", 100, localTime);
		File c = new File(home, "c", 100, localTime);
		File d = new File(home, "d", 100, localTime);
		File e = new File(code, "e", 100, localTime);
		File f = new File(code, "f", 100, localTime);

		FileSystem.getFileSystem().addRootDir(root);
	}

	private String[] dirToStringArray(Directory d) {
		Optional<Directory> optDir = Optional.ofNullable(d.getParent());
		String[] dirInfo = { Boolean.toString(d.isDirectory()), d.getName(), Integer.toString(d.getSize()),
				d.getCreationTime().toString(), optDir.isPresent() ? d.getParent().getName() : null,
				Integer.toString(d.getTotalSize()), Integer.toString(d.countChildren()) };
		return dirInfo;
	}

	@Test
	public void  verifyDirectoryEqualityRoot() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		String[] expected = { "true", "root", "0", localTime.toString(), null, "600", "2" };
		Directory actual = fileSystem.getRootDirs().get(0).findDirByName("root");
		assertArrayEquals(expected, dirToStringArray(actual));
	}

	@Test
	public void verifyDirectoryEqualityHome() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		String[] expected = { "true", "home", "0", localTime.toString(), "root", "400", "3" };
		Directory actual = fileSystem.getRootDirs().get(0).findDirByName("home");
		assertArrayEquals(expected, dirToStringArray(actual));
	}

	@Test
	public void verifyDirectoryEqualityApplications() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		String[] expected = { "true", "applications", "0", localTime.toString(), "root", "200", "2" };
		Directory actual = fileSystem.getRootDirs().get(0).findDirByName("applications");
		assertArrayEquals(expected, dirToStringArray(actual));
	}

	@Test
	public void verifyDirectoryEqualityCode() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		String[] expected = { "true", "code", "0", localTime.toString(), "home", "200", "2" };
		Directory actual = fileSystem.getRootDirs().get(0).findDirByName("code");
		assertArrayEquals(expected, dirToStringArray(actual));
	}
	
	@Test
	void checkDirectory() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		assertTrue(fileSystem.getRootDirs().get(0).findDirByName("root").isDirectory());
		assertTrue(fileSystem.getRootDirs().get(0).findDirByName("home").isDirectory());
		assertTrue(fileSystem.getRootDirs().get(0).findDirByName("applications").isDirectory());
		assertTrue(fileSystem.getRootDirs().get(0).findDirByName("code").isDirectory());
	}

	@Test
	void verifyDriectoriesName() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		assertSame("root", fileSystem.getRootDirs().get(0).findDirByName("root").getName());
		assertSame("home", fileSystem.getRootDirs().get(0).findDirByName("home").getName());
		assertSame("applications", fileSystem.getRootDirs().get(0).findDirByName("applications").getName());
		assertSame("code", fileSystem.getRootDirs().get(0).findDirByName("code").getName());
	}
	
	@Test
	void verifyFilesName() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		assertSame("a", fileSystem.getRootDirs().get(0).findFileByName("a").getName());
		assertSame("b", fileSystem.getRootDirs().get(0).findFileByName("b").getName());
		assertSame("c", fileSystem.getRootDirs().get(0).findFileByName("c").getName());
		assertSame("d", fileSystem.getRootDirs().get(0).findFileByName("d").getName());
		assertSame("e", fileSystem.getRootDirs().get(0).findFileByName("e").getName());
		assertSame("f", fileSystem.getRootDirs().get(0).findFileByName("f").getName());
	}

	@Test
	void verifyDriectoriesSizes() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		assertEquals(600, fileSystem.getRootDirs().get(0).findDirByName("root").getTotalSize());
		assertEquals(400, fileSystem.getRootDirs().get(0).findDirByName("home").getTotalSize());
		assertEquals(200, fileSystem.getRootDirs().get(0).findDirByName("applications").getTotalSize());
		assertEquals(200, fileSystem.getRootDirs().get(0).findDirByName("code").getTotalSize());
	}

	

	@Test
	void verifySubDirectories() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		assertSame("applications",
				fileSystem.getRootDirs().get(0).findDirByName("root").getSubDirectories().get(0).getName());
		assertSame("home", fileSystem.getRootDirs().get(0).findDirByName("root").getSubDirectories().get(1).getName());
		assertSame("code", fileSystem.getRootDirs().get(0).findDirByName("home").getSubDirectories().get(0).getName());
	}

	@Test
	void verfiyCount() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		assertEquals(2, fileSystem.getRootDirs().get(0).findDirByName("root").countChildren());
		assertEquals(2, fileSystem.getRootDirs().get(0).findDirByName("applications").countChildren());
		assertEquals(3, fileSystem.getRootDirs().get(0).findDirByName("home").countChildren());
		assertEquals(2, fileSystem.getRootDirs().get(0).findDirByName("code").countChildren());
	}

	
}