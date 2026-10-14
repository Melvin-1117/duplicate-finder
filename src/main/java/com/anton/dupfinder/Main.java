package com.anton.dupfinder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void  main(String[] args) {
        System.out.println("Duplicate file finder started");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the directory: ");
        String input = sc.nextLine();
        Path rootPath = Path.of(input);
        if (Files.exists(rootPath) && Files.isDirectory(rootPath)) {
            FileScanner scanner = new FileScanner();
            List<Path> files = null;
            try {
                files = scanner.scanFiles(rootPath);
            }catch(IOException e){
                System.out.println("The error occurec is "+ e.getMessage());
                return;
            }
            if(files.isEmpty()){
                System.out.println("No Files found in the selected directory");
                return;
            }
            Map<String, List<Path>> groupDup = DuplicateGrouper.duplicateGrouper(files);
            List<DuplicateResult> duplicateResults = DuplicateHandler.handleDuplicate(groupDup , sc);
            Path reportPath = Path.of("duplicates_report.txt");
            ReportWriter.writeReport(duplicateResults, reportPath);
        } else {
            System.out.println("Invalid directory. Please enter a valid directory path.");
        }

    }
}

