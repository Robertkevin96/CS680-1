package edu.umb.cs680.hw10;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw10.APFS;
import edu.umb.cs680.hw10.ApfsDirectory;

public class APFSTest {
static LocalDateTime localTime = LocalDateTime.of(2020, 06, 12, 0, 0);
	
	@BeforeAll
	public static void initialize() {

		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) ApfsFileSystem.initFileSystem("yashmahant", 5000);
		
	}

	private String[] apfsToStringArray(ApfsDirectory d) {
		Optional<ApfsDirectory> optDirectory = Optional.ofNullable(d.getParent());
		String[] dirInfo = { Boolean.toString(d.isDirectory()), d.getName(), Integer.toString(d.getSize()),
				d.getCreationTime().toString(), optDirectory.isPresent() ? d.getParent().getName() : null,
				Integer.toString(d.getTotalSize()), Integer.toString(d.countChildren()), d.getOwnerName(),
				d.getLastModified().toString() };
		return dirInfo;
	}

	@Test
	public void verifyRootDirectory_Success() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) ApfsFileSystem.getRootDirectory();
		String[] expected = { "true", "root", "0", localTime.toString(), null, "0", "0", "yash",
				localTime.toString() };
		ApfsDirectory actual = root.findDirByName("root");
		assertArrayEquals(expected, apfsToStringArray(actual));
	}
	
	
}
