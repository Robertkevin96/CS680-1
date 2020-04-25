package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw08.Directory;
import edu.umb.cs680.hw08.FSElement;
import edu.umb.cs680.hw08.File;
import edu.umb.cs680.hw08.FileSystem;
import edu.umb.cs680.hw08.Link;

class LinkTest {

	static LocalDateTime localTime = LocalDateTime.now();

	@SuppressWarnings("unused")
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
		Link x = new Link(home, "x", 0, localTime, applications);
		Link y = new Link(code, "y", 0, localTime, b);

		FileSystem.getFileSystem().addRootDir(root);
	}

	private String[] linkToStringArray(FSElement f) {
		Optional<Directory> optionalDirectory = Optional.ofNullable(f.getParent());
		String[] fsElementInfo = { Boolean.toString(f.isDirectory()), f.getName(), Integer.toString(f.getSize()),
				f.getCreationTime().toString(), optionalDirectory.isPresent() ? f.getParent().getName() : null };
		return fsElementInfo;
	}

	@Test
	public void verifyLinkToApplication_Success() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		String[] expected = { "true", "applications", "0", localTime.toString(), "root" };
		Directory actual = (Directory) fileSystem.getRootDirs().get(0).findLinkByName("x").getTarget();
		assertArrayEquals(expected, linkToStringArray(actual));
	}
	
	@Test
	public void verifyLinkToFileB_Success() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		String[] expected = { "false", "b", "100", localTime.toString(), "applications" };
		File actual = (File) fileSystem.getRootDirs().get(0).findLinkByName("y").getTarget();
		assertArrayEquals(expected, linkToStringArray(actual));
	}

}
