package edu.umb.cs680.hw12;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw12.APFS;
import edu.umb.cs680.hw12.ApfsDirectory;
import edu.umb.cs680.hw12.ApfsFile;
import edu.umb.cs680.hw12.ApfsLink;

public class FileSystemTest {
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
	
	private String[] fileSystemToStringArray(ApfsDirectory d) {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		Optional<ApfsDirectory> optionalDirectory = Optional.ofNullable(d.getParent());
		String[] dirInfo = { Boolean.toString(d.isDirectory()), d.getName(), Integer.toString(d.getSize()),
				d.getCreationTime().toString(), optionalDirectory.isPresent() ? d.getParent().getName() : null,
				Integer.toString(d.getTotalSize()), Integer.toString(d.countChildren()),
				ApfsFileSystem.getFileSystemName(), Integer.toString(ApfsFileSystem.getCapacity()), d.getOwnerName(),
				d.getLastModified().toString() };
		return dirInfo;
	}

	@Test
	public void verifyFileSystem() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) ApfsFileSystem.getRootDirectory();
		String[] expected = { "true", "root", "0", localTime.toString(), null, "600", "2", "yashmahant", "5000", "yash",
				localTime.toString() };
		ApfsDirectory actual = root.findDirByName("root");
		assertArrayEquals(expected, fileSystemToStringArray(actual));
	}

	@Test
	public void verifyOwnerOfFileSystem() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) ApfsFileSystem.getRootDirectory();
		assertEquals(root.getOwnerName(), "yash");
		assertEquals(root.getLastModified(), localTime);
	}
}
