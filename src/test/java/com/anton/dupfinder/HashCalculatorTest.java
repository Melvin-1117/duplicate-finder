package com.anton.dupfinder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;
class HashCalculatorTest {
    @TempDir
    Path tempDir;

    @Test
    void sameContentProducesSameHash() throws IOException {
        Path firstFile = tempDir.resolve("first.txt");
        Path secondFile = tempDir.resolve("second.txt");
        Files.writeString(firstFile, "Hello Java");
        Files.writeString(secondFile, "Hello Java");
        HashCalculator calci = new HashCalculator();
        String firstHash = calci.calculateHash(firstFile);
        String secondHash = calci.calculateHash(secondFile);
        assertEquals(firstHash, secondHash);
    }

    @Test
    void differentContentProducesDifferentHashes() throws IOException {
        Path firstFile = tempDir.resolve("first.txt");
        Path secondFile = tempDir.resolve("second.txt");
        Files.writeString(firstFile, "Hello Java");
        Files.writeString(secondFile, "Hello java");
        HashCalculator calci = new HashCalculator();
        String firstHash = calci.calculateHash(firstFile);
        String secondHash = calci.calculateHash(secondFile);
        assertNotEquals(firstHash, secondHash);
    }

    @Test
    void hashLengthIs64Characters() throws IOException {
        Path hashCheck = tempDir.resolve("hash.txt");
        Files.writeString(hashCheck, "hash verification");
        HashCalculator calci = new HashCalculator();
        String hashLength = calci.calculateHash(hashCheck);
        assertEquals(64, hashLength.length());
    }

    @Test
    void missingFileReturnsNull() {
        Path missingFile = tempDir.resolve("missing.txt");
        HashCalculator calci = new HashCalculator();
        String result = calci.calculateHash(missingFile);
        assertNull(result);

    }
}