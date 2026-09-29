package com.anton.dupfinder;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class DuplicateGrouper{
    public static Map<String,List<Path>> duplicateGrouper(List<Path>files){                         // this method should return a map contains a hash and all the duplicate files in an arrayList
        Map<String, List<Path>> groupDuplicates = new HashMap<>();                                  // this line creates a hashmap to store the hash and files
        HashCalculator calculator = new HashCalculator();                                           // this object is calls the hashcalculator class and reuse it
        for(Path file : files){                                                                     // for each loop for every hash and file iteration
            String hash= calculator.calculateHash(file);                                            // calculate the hash for every file in each iterations
            if(groupDuplicates.containsKey(hash)){                                                  // if hash already exists the if block executes and add the file too existingfile Arraylist
                List<Path> existingFiles = groupDuplicates.get(hash);
                existingFiles.add(file);
            }else{
                ArrayList<Path> newFiles = new ArrayList<>();                                       // if new file is detected then a new map key is assigned to it and added to it using builtin method
                newFiles.add(file);
                groupDuplicates.put(hash,newFiles);
            }
        }
        return groupDuplicates;                                                                    // returns the map consisting the grouped duplicate files.
    }
}


//For every file, calculate its hash;
//if the hash already exists, add the file to that group;
//otherwise create a new group.
