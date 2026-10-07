package com.anton.dupfinder;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class DuplicateHandler {
    public static void handleDuplicate(Map<String, List<Path>> groupedFiles, Scanner sc) {
        DuplicateDeleter deleter = new DuplicateDeleter();
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
                int choice = 0;
                do {
                    System.out.println("Which file do you want to keep?");
                    choice = sc.nextInt();
                } while (choice <= 0 || choice > files.size());
                sc.nextLine();
                int index = choice - 1;
                Path selectedFile = files.get(index);
                System.out.println("Selected file: " + selectedFile);
                System.out.println("The following files will be deleted:");
                for (int i = 0; i < files.size(); i++) {
                    if (i != index) {
                        Path fileToDelete = files.get(i);
                        System.out.println("Will be deleted: " + fileToDelete);
                    }
                }
                String confirmation ="";
                do {
                    System.out.println("Confirm Deletion? (Y/N) :");
                    confirmation = sc.nextLine();
                    if(!confirmation.equalsIgnoreCase("N") && !confirmation.equalsIgnoreCase("Y")){
                        System.out.println("Please enter a valid Y/N");
                    }
                }while(!confirmation.equalsIgnoreCase("N") && !confirmation.equalsIgnoreCase("Y"));
                if (confirmation.equalsIgnoreCase("Y")) {
                    System.out.println("Deletion confirmed");
                    deleter.deleteDuplicates(files,index);
                }

            }
        }
        if (!duplicateFound) {
            System.out.println("No duplicate files were found.");
        }
    }
}
