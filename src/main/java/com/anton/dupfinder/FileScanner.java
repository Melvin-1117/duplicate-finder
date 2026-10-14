package com.anton.dupfinder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.io.IOException;
import java.util.stream.Stream;

public class FileScanner {
    public List<Path> scanFiles(Path rootPath) throws IOException {   //access specifier + return type + method name + parameter with variable name inside paranthesis
        // public + List<Path> will return containing path + name of the method + receives path input
        try (Stream<Path> stream = Files.walk(rootPath)) {
            return stream.filter(path -> Files.isRegularFile(path))                     // Recursively traverses the directory , filters and keeps only regular files
                    .collect(Collectors.toList());                                      // collector is a build in stream method collects the filtered regular files into a list
        }
    }
}
