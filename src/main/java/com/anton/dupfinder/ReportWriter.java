package com.anton.dupfinder;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;

public class ReportWriter {
    public static void writeReport(Map<String, List<Path>> groupedFile, Path reportPath) {
        try {
            StringBuilder reportContent = new StringBuilder();
            reportContent.append("=====================================\n");
            reportContent.append("DUPLICATE FILE REPORT\n");
            reportContent.append("=====================================\n");
            for (Map.Entry<String, List<Path>> entry : groupedFile.entrySet()) {
                List<Path> files = entry.getValue();
                if (files.size() > 1) {
                    reportContent.append("Hash: " + entry.getKey() + "\n");
                    int num = 1;
                    reportContent.append("Files:\n");
                    for (Path file : files) {
                        reportContent.append(num + ". " + file+"\n");
                        num++;
                    }
                    Files.writeString(reportPath, reportContent.toString());
                }
            }
        } catch (IOException e) {
                    System.out.println("Unable to write report"+e.getMessage());
        }
    }
}