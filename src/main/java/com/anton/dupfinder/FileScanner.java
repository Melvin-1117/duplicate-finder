import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
    public List<Path> scanFiles(Path rootPath){   //access specifier + return type + method name + parameter with variable name inside paranthesis
        // public + List<Path> will return containing path + name of the method + receives path input
       return Files.walk(rootPath).filter(path -> Files.isRegularFile(path))                     // Recursively traverses the directory , filters and keeps only regular files
                .collect(Collectors.toList());                                      // collector build in stream method collects the filtered regular files into a list
}

