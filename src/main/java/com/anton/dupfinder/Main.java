package com.anton.dupfinder;

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
            List<Path> files = scanner.scanFiles(rootPath);
            Map<String, List<Path>> groupDup = DuplicateGrouper.duplicateGrouper(files);
            DuplicateHandler.handleDuplicate(groupDup , sc);
            Path reportPath = Path.of("duplicates_report.txt");
            ReportWriter.writeReport(groupDup, reportPath);
        } else {
            System.out.println("Invalid directory. Please enter a valid directory path.");
        }

    }
}

