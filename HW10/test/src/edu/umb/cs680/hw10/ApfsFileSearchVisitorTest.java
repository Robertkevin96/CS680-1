package edu.umb.cs680.hw10;

import edu.umb.cs680.hw10.APFS.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApfsFileSearchVisitorTest {
	static LocalDateTime localTime = LocalDateTime.of(2020, 06, 12, 0, 0);

	private static APFS apfs;
	private static ApfsDirectory root, applications, home, code;
	private static ApfsFile a, b, c, d, e, f;
	private static ApfsLink x, y;

	@BeforeAll
	public static void setUp() {
		apfs = APFS.getAPFSFileSystem();
		apfs.initFileSystem("yashmahant", 5000);
		root = (ApfsDirectory) apfs.getRootDirectory();

		applications = new ApfsDirectory(root, "applications", 0, localTime, "yash", localTime);
		home = new ApfsDirectory(root, "home", 0, localTime, "yash", localTime);

		a = new ApfsFile(applications, "a", 100, localTime, "yash", localTime);
		b = new ApfsFile(applications, "b", 100, localTime, "yash", localTime);

		c = new ApfsFile(home, "c", 100, localTime, "yash", localTime);
		d = new ApfsFile(home, "d", 100, localTime, "yash", localTime);
		code = new ApfsDirectory(home, "code", 0, localTime, "yash", localTime);

		e = new ApfsFile(code, "e", 100, localTime, "yash", localTime);
		f = new ApfsFile(code, "f", 100, localTime, "guest", localTime);

		x = new ApfsLink(home, "x", 0, localTime, "yash", localTime, applications);
		y = new ApfsLink(code, "y", 0, localTime, "yash", localTime, b);

	}
	@Test
	public void searchFileAInHome() {
		LinkedList<ApfsFile> expected = new LinkedList<>();

		ApfsFileSearchVisitor v = new ApfsFileSearchVisitor("a");
		home.accept(v);
		LinkedList<ApfsFile> actual = v.getFoundFiles();
		assertEquals(expected, actual);
	}
	@Test
	public void searchFileBInHome() {
		LinkedList<ApfsFile> expected = new LinkedList<>();

		ApfsFileSearchVisitor v = new ApfsFileSearchVisitor("b");
		home.accept(v);
		LinkedList<ApfsFile> actual = v.getFoundFiles();
		assertEquals(expected, actual);
	}
	@Test
	public void searchFileFInRoot() {
		LinkedList<ApfsFile> expected = new LinkedList<>(Arrays.asList(f));

		ApfsFileSearchVisitor v = new ApfsFileSearchVisitor("f");
		root.accept(v);
		LinkedList<ApfsFile> actual = v.getFoundFiles();
		assertEquals(expected, actual);
	}
	@Test
	public void searchFileEInRoot() {
		LinkedList<ApfsFile> expected = new LinkedList<>(Arrays.asList(e));

		ApfsFileSearchVisitor v = new ApfsFileSearchVisitor("e");
		root.accept(v);
		LinkedList<ApfsFile> actual = v.getFoundFiles();
	
	}
}
