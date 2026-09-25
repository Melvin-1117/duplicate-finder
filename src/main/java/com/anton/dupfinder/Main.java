package com.anton.dupfinder;
import java.nio.file.Path;
import java.util.List;
public class Main {
    public static void main(String [] args){
        System.out.print("Duplicate file finder started");
        FileScanner scanner = new FileScanner();
        Path rootPath = Path.of("C:/Users/anton/duplicate-test");
        scanner.scanFiles(rootPath);
        List<Path> files = scanner();


    }
}