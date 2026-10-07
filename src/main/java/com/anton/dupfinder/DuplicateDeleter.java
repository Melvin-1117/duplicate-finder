package com.anton.dupfinder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DuplicateDeleter {
    public void deleteDuplicates(List<Path> files, int keepIndex) {

        for (int i = 0; i < files.size(); i++) {

            if (i != keepIndex) {
                Path fileToDelete = files.get(i);
                try {
                    Files.delete(fileToDelete);
                    System.out.println("Deleted: "+fileToDelete);
                } catch (IOException e) {
                    System.out.println("Error deleting the file: " + fileToDelete);
                    System.out.println("Reason: "+e.getMessage());
                }
            }
        }
    }
}
