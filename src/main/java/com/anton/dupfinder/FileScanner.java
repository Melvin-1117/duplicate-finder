import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.io.IOException;
import java.util.stream.Stream;

public List<Path> scanFiles(Path rootPath) {   //access specifier + return type + method name + parameter with variable name inside paranthesis
    // public + List<Path> will return containing path + name of the method + receives path input
    try(Stream<Path> stream = Files.walk(rootPath)){
        return stream.filter(path -> Files.isRegularFile(path))                     // Recursively traverses the directory , filters and keeps only regular files
                .collect(Collectors.toList());                                      // collector is a build in stream method collects the filtered regular files into a list
    } catch (IOException fileMissing) {                                                                 //catch handles the exception throws in the file.walk, for example if the file or directory is missing it returns a message.
        System.out.println("Unable to scan directory : " + fileMissing.getMessage());
        return List.of();
    }
}

