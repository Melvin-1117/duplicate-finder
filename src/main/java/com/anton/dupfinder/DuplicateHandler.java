package com.anton.dupfinder;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class DuplicateHandler {
    public static void handleDuplicate(Map<String, List<Path>> groupedFiles) {
        for(Map.Entry<String , List<Path>> entry : groupedFiles.entrySet()){
            List<Path> files = entry.getValue();
            if(files.size()>1){
                System.out.println(entry.getKey());
                for(Path file : files){
                    System.out.println(file);
                }
            }
        }
    }
}
