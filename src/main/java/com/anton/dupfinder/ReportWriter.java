package com.anton.dupfinder;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;

public class ReportWriter {
    public static void writeReport(Map<String, List<Path>> groupedFile, Path reportPath) {                  // Receives the grouped duplicate files and the path where the report should be saved.
        try {
            StringBuilder reportContent = new StringBuilder();                                              // Creates a StringBuilder to construct the complete report in memory.
            reportContent.append("=====================================\n");
            reportContent.append("DUPLICATE FILE REPORT\n");
            reportContent.append("=====================================\n");
            for (Map.Entry<String, List<Path>> entry : groupedFile.entrySet()) {                            // Iterates through every hash group stored in the duplicate map. map.entrySet() is used when both key and value is needed
                List<Path> files = entry.getValue();                                                        // This line is responsible for getting the list of files respected to their hash
                if (files.size() > 1) {
                    reportContent.append("Hash: " + entry.getKey() + "\n");
                    int num = 1;
                    reportContent.append("Files:\n");
                    for (Path file : files) {
                        reportContent.append(num + ". " + file+"\n");
                        num++;
                    }
                    Files.writeString(reportPath, reportContent.toString());                                // Converts the StringBuilder into a String and writes the complete report to the specified file.
                }
            }
        } catch (IOException e) {
                    System.out.println("Unable to write report"+e.getMessage());
        }
    }
}