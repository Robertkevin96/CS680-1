package edu.umb.cs680.hw10;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw10.APFS;
import edu.umb.cs680.hw10.ApfsDirectory;
import edu.umb.cs680.hw10.ApfsFile;
import edu.umb.cs680.hw10.ApfsLink;
import edu.umb.cs680.hw10.FSElement;

public class ApfsLinkTest {
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
	
	private String[] linkToStringArray(FSElement f) {
		Optional<ApfsDirectory> optionalDirectory = Optional.ofNullable(f.getParent());
		String[] fsElementInfo = { Boolean.toString(f.isDirectory()), f.getName(), Integer.toString(f.getSize()),
				f.getCreationTime().toString(), optionalDirectory.isPresent() ? f.getParent().getName() : null };
		return fsElementInfo;
	}
	@Test
	public void verifyLinkToApplication_Success() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) ApfsFileSystem.getRootDirectory();
		String[] expected = { "true", "applications", "0", localTime.toString(), "root" };
		ApfsDirectory actual = (ApfsDirectory) root.findLinkByName("x").getTarget();
		assertArrayEquals(expected, linkToStringArray(actual));
	}

	@Test
	public void verifyLinkToFileB_Success() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) ApfsFileSystem.getRootDirectory();
		String[] expected = { "false", "b", "100", localTime.toString(), "applications" };
		ApfsFile actual = (ApfsFile) root.findLinkByName("y").getTarget();
		assertArrayEquals(expected, linkToStringArray(actual));
	}

}
