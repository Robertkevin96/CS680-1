package edu.umb.cs680.hw15;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw15.APFS.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AlphabeticalComparatorTest {

	static APFS ApfsFileSystem = APFS.getAPFSFileSystem();
	static ApfsDirectory root;
	static ApfsDirectory applications;
	static ApfsDirectory home;
	static ApfsDirectory code;
	static ApfsFile a;
	static ApfsFile b;
	static ApfsFile c;
	static ApfsFile d;
	static ApfsFile e;
	static ApfsFile f;
	static ApfsLink x;
	static ApfsLink y;

	static LocalDateTime localTime = LocalDateTime.now();

	@BeforeAll
	public static void initialize() {

		root = (ApfsDirectory) ApfsFileSystem.initFileSystem("yashmahant", 5000);
		applications = new ApfsDirectory(root, "applications", 0, localTime, "yash", localTime);
		home = new ApfsDirectory(root, "home", 0, localTime, "yash", localTime);
		code = new ApfsDirectory(home, "code", 0, localTime, "yash", localTime);
		a = new ApfsFile(applications, "a", 100, localTime, "yash", localTime);
		b = new ApfsFile(applications, "b", 100, localTime, "yash", localTime);
		c = new ApfsFile(home, "c", 100, localTime, "yash", localTime);
		d = new ApfsFile(home, "d", 100, localTime, "yash", localTime);
		e = new ApfsFile(code, "e", 100, localTime, "yash", localTime);
		f = new ApfsFile(code, "f", 100, localTime, "guest", localTime);
		x = new ApfsLink(home, "x", 0, localTime, "yash", localTime, applications);
		y = new ApfsLink(code, "y", 0, localTime, "yash", localTime, b);

		// Last Modified Dates
		root.setLastModified(LocalDateTime.of(2020, 5, 10, 11, 0));
		applications.setLastModified(LocalDateTime.of(2020, 5, 11, 11, 0));
		home.setLastModified(LocalDateTime.of(2020, 5, 12, 11, 0));
		code.setLastModified(LocalDateTime.of(2020, 5, 13, 11, 0));

		a.setLastModified(LocalDateTime.of(2020, 5, 11, 11, 0));
		b.setLastModified(LocalDateTime.of(2020, 5, 11, 11, 0));

		c.setLastModified(LocalDateTime.of(2020, 5, 12, 11, 0));
		d.setLastModified(LocalDateTime.of(2020, 5, 12, 11, 0));

		e.setLastModified(LocalDateTime.of(2020, 5, 13, 11, 0));
		f.setLastModified(LocalDateTime.of(2020, 5, 13, 11, 0));

		x.setLastModified(LocalDateTime.of(2020, 5, 12, 11, 0));
		y.setLastModified(LocalDateTime.of(2020, 5, 13, 11, 0));
	}

	private String[] APFSElementToString(LinkedList<ApfsElement> elements) {
		String[] elems = new String[elements.size()];
		for (int i = 0; i < elements.size(); i++) {
			elems[i] = elements.get(i).getName();
		}
		return elems;
	}

	private String[] APFSDirectoryToString(LinkedList<ApfsDirectory> elements) {
		String[] elems = new String[elements.size()];
		for (int i = 0; i < elements.size(); i++) {
			elems[i] = elements.get(i).getName();
		}
		return elems;
	}

	private String[] APFSFileToString(LinkedList<ApfsFile> elements) {
		String[] elems = new String[elements.size()];
		for (int i = 0; i < elements.size(); i++) {
			elems[i] = elements.get(i).getName();
		}
		return elems;
	}

	// alphabetical order
	@Test
	public void getChilrenOfRoot() {
		String[] expected = { "applications", "home" };
		LinkedList<ApfsElement> children = root.getChildren();
		String[] actual = APFSElementToString(children);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void getChilrenOfApplications() {
		String[] expected = { "a", "b" };
		LinkedList<ApfsElement> children = applications.getChildren();
		String[] actual = APFSElementToString(children);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void getChilrenOfHome() {
		String[] expected = { "c", "code", "d", "x" };
		LinkedList<ApfsElement> children = home.getChildren();
		String[] actual = APFSElementToString(children);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void getChilrenOfCode() {
		String[] expected = { "e", "f", "y" };
		LinkedList<ApfsElement> children = code.getChildren();
		String[] actual = APFSElementToString(children);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void getSubDirectoriesOfRoot() {
		String[] expected = { "applications", "home" };
		LinkedList<ApfsDirectory> subDirectories = root.getSubDirectories();
		String[] actual = APFSDirectoryToString(subDirectories);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void getSubDirectoriesOfHome() {
		String[] expected = { "code" };
		LinkedList<ApfsDirectory> subDirectories = home.getSubDirectories();
		String[] actual = APFSDirectoryToString(subDirectories);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void getSubDirectoriesOfApplications() {
		String[] expected = {};
		LinkedList<ApfsDirectory> subDirectories = applications.getSubDirectories();
		String[] actual = APFSDirectoryToString(subDirectories);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void getSubDirectoriesOfCode() {
		String[] expected = {};
		LinkedList<ApfsDirectory> subDirectories = code.getSubDirectories();
		String[] actual = APFSDirectoryToString(subDirectories);
		assertArrayEquals(expected, actual);
	}
	@Test
	public void sortFilesOfApplications() {
		String[] expected = { "a", "b" };
		LinkedList<ApfsFile> files = applications.getFiles();
		String[] actual = APFSFileToString((files));
		assertArrayEquals(expected, actual);
	}
	@Test
	public void sortFilesOfHome() {
		String[] expected = { "c", "d" };
		LinkedList<ApfsFile> files = home.getFiles();
		String[] actual = APFSFileToString((files));
		assertArrayEquals(expected, actual);
	}
	@Test
	public void sortFilesOfCode() {
		String[] expected = { "e", "f" };
		LinkedList<ApfsFile> files = code.getFiles();
		String[] actual = APFSFileToString((files));
		assertArrayEquals(expected, actual);
	}
}
