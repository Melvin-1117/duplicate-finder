package com.anton.dupfinder;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DuplicateHandler {
    public static void handleDuplicate(Map<String, List<Path>> groupedFiles, Scanner sc) {
        boolean duplicateFound = false;
        for (Map.Entry<String, List<Path>> entry : groupedFiles.entrySet()) {
            List<Path> files = entry.getValue();
            if (files.size() > 1) {
                duplicateFound = true;
                System.out.println("Hash: " + entry.getKey());
                int num = 1;
                System.out.println("Files:");
                for (Path file : files) {
                    System.out.println(num + ". " + file);
                    num++;
                }
                System.out.println("--------------------------------------------------------------------------------");
                int choice=0;
                do{
                    System.out.println("Which file do you want to keep?");
                    choice =sc.nextInt();
                }while(choice<=0||choice>files.size());
            }
        }
        if (!duplicateFound) {
            System.out.println("No duplicate files were found.");
        }
    }
}
