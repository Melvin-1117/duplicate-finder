package com.anton.dupfinder;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;
class HashCalculatorTest {
    @TempDir
    Path tempDir;
    @Test
        void sameContentProducesSameHash() throws IOException {
            Path firstFile = tempDir.resolve("first.txt");
            Path secondFile= tempDir.resolve("second.txt");
            Files.writeString(firstFile,"Hello Java");
            Files.writeString(secondFile,"Hello Java");
            HashCalculator calci = new HashCalculator();
            String firstHash = calci.calculateHash(firstFile);
            String secondHash = calci.calculateHash(secondFile);
            assertEquals(firstHash,secondHash);
        }
}