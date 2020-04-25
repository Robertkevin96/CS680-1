package edu.umb.cs680.hw07;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FileTest {

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

	private String[] fileToStringArray(File f) {
		Optional<Directory> optionalDirectory = Optional.ofNullable(f.getParent());
		String[] fileInfo = { Boolean.toString(f.isDirectory()), f.getName(), Integer.toString(f.getSize()),
				f.getCreationTime().toString(), optionalDirectory.isPresent() ? f.getParent().getName() : null };
		return fileInfo;
	}
	
	@Test
	void verifyFileEqualityApplications() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		assertSame("a", fileSystem.getRootDirs().get(0).findDirByName("applications").getFiles().get(0).getName());
		assertSame("b", fileSystem.getRootDirs().get(0).findDirByName("applications").getFiles().get(1).getName());
	}
	
	@Test
	void verifyFileEqualityHome() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		assertSame("c", fileSystem.getRootDirs().get(0).findDirByName("home").getFiles().get(0).getName());
		assertSame("d", fileSystem.getRootDirs().get(0).findDirByName("home").getFiles().get(1).getName());

	}
	@Test
	void verifyFileEqualityCode() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		assertSame("e", fileSystem.getRootDirs().get(0).findDirByName("code").getFiles().get(0).getName());
		assertSame("f", fileSystem.getRootDirs().get(0).findDirByName("code").getFiles().get(1).getName());

	}

	@Test
	void verifyIsNotDirectory() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		assertFalse(fileSystem.getRootDirs().get(0).findFileByName("a").isDirectory());
		assertFalse(fileSystem.getRootDirs().get(0).findFileByName("b").isDirectory());
		assertFalse(fileSystem.getRootDirs().get(0).findFileByName("c").isDirectory());
		assertFalse(fileSystem.getRootDirs().get(0).findFileByName("d").isDirectory());
		assertFalse(fileSystem.getRootDirs().get(0).findFileByName("e").isDirectory());
		assertFalse(fileSystem.getRootDirs().get(0).findFileByName("f").isDirectory());
	}
	
	
	@Test
	public void verifyFileA() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		String[] expected = { "false", "a", "100", localTime.toString(), "applications" };
		File actual = fileSystem.getRootDirs().get(0).findFileByName("a");
		assertArrayEquals(expected, fileToStringArray(actual));
	}
	
	@Test
	public void verifyFileB() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		String[] expected = { "false", "b", "100", localTime.toString(), "applications" };
		File actual = fileSystem.getRootDirs().get(0).findFileByName("b");
		assertArrayEquals(expected, fileToStringArray(actual));
	}


	@Test
	public void verifyFileC() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		String[] expected = { "false", "c", "100", localTime.toString(), "home" };
		File actual = fileSystem.getRootDirs().get(0).findFileByName("c");
		assertArrayEquals(expected, fileToStringArray(actual));
	}
	
	@Test
	public void verifyFileD() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		String[] expected = { "false", "d", "100", localTime.toString(), "home" };
		File actual = fileSystem.getRootDirs().get(0).findFileByName("d");
		assertArrayEquals(expected, fileToStringArray(actual));
	}

	@Test
	public void verifyFileE() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		String[] expected = { "false", "e", "100", localTime.toString(), "code" };
		File actual = fileSystem.getRootDirs().get(0).findFileByName("e");
		assertArrayEquals(expected, fileToStringArray(actual));
	}
	@Test
	public void verifyFileF() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		String[] expected = { "false", "f", "100", localTime.toString(), "code" };
		File actual = fileSystem.getRootDirs().get(0).findFileByName("f");
		assertArrayEquals(expected, fileToStringArray(actual));
	}
}