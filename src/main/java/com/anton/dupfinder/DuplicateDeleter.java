package com.anton.dupfinder;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DuplicateDeleter {
    public void deleteDuplicates(List<Path> files, int keepIndex){
        try {
            for (int i = 0; i < files.size(); i++) {
                if (i != keepIndex) {
                    Path fileToDelete = files.get(i);
                    Files.delete(fileToDelete);
                }
            }
        }catch (IOException e){
            System.out.println("Error deleting the file: "+e.getMessage());
        }
    }
}
