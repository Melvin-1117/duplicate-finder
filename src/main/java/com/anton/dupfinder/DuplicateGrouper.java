package com.anton.dupfinder;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class DuplicateGrouper{
    public static Map<String,List<Path>> duplicateGrouper(List<Path>files){
        Map<String, List<Path>> groupDuplicates = new HashMap<>();
        HashCalculator calculator = new HashCalculator();
        for(Path file : files){
            String hash= calculator.calculateHash(file);
            if(groupDuplicates.containsKey(hash)){
                List<Path> existingFiles = groupDuplicates.get(hash);
                existingFiles.add(file);
            }else{
                ArrayList<Path> newFiles = new ArrayList<>();
                newFiles.add(file);
                groupDuplicates.put(hash,newFiles);
            }
        }
        return groupDuplicates;
    }
}