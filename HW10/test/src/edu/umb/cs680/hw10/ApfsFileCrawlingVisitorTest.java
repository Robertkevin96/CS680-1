package edu.umb.cs680.hw10;

import edu.umb.cs680.hw10.APFS.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApfsFileCrawlingVisitorTest {
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
	public void fileCrawlingOfRoot() {
		LinkedList<ApfsFile> expected = new LinkedList<>(Arrays.asList(a, b, c, d, e, f));

		ApfsFileCrawlingVisitor v = new ApfsFileCrawlingVisitor();
		root.accept(v);
		LinkedList<ApfsFile> actual = v.getFiles();
		assertEquals(expected, actual);
	}

	@Test
	public void fileCrawlingOfCode() {
		LinkedList<ApfsFile> expected = new LinkedList<>(Arrays.asList(e, f));

		ApfsFileCrawlingVisitor v = new ApfsFileCrawlingVisitor();
		code.accept(v);
		LinkedList<ApfsFile> actual = v.getFiles();
		assertEquals(expected, actual);
	}
	@Test
	public void fileCrawlingOfApplications() {
		LinkedList<ApfsFile> expected = new LinkedList<>(Arrays.asList(a, b));

		ApfsFileCrawlingVisitor v = new ApfsFileCrawlingVisitor();
		applications.accept(v);
		LinkedList<ApfsFile> actual = v.getFiles();
		assertEquals(expected, actual);
	}

}
