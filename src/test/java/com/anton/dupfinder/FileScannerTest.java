package com.anton.dupfinder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class FileScannerTest {
    @TempDir
    Path tempDir;
    @Test
    void scanFilesFindsFilesRecursively() throws IOException{
        Path firstFile = tempDir.resolve("first.txt");
        Path subDir = tempDir.resolve("subfolder");
        Files.createDirectories(subDir);
        Path secondFile = subDir.resolve("second.txt");
        Files.writeString(firstFile, "Hello Java");
        Files.writeString(secondFile, "Hello Java");
        FileScanner scanner = new FileScanner();
        List<Path> scannedFiles = scanner.scanFiles(tempDir);
        assertEquals(2,scannedFiles.size());
    }
}
