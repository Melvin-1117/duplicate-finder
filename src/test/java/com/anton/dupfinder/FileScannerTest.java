package com.anton.dupfinder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        assertTrue(scannedFiles.contains(firstFile));
        assertTrue(scannedFiles.contains(secondFile));
    }
    @Test
    void emptyDirectoryReturnsEmptyList() throws IOException {
        FileScanner scanner = new FileScanner();
        List<Path> scannedFiles = null;
        try {
            scannedFiles = scanner.scanFiles(tempDir);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertTrue(scannedFiles.isEmpty());
    }
}
