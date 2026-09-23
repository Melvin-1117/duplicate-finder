import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
public List<Path> scanFiles(Path rootPath){   //access specifier + return type + method name + parameter with variable name inside paranthesis
                                              // public + List<Path> will return containing path + name of the method + receives path input
    Files.walk(rootPath);                     // this line is responsible for repeatedly iterating through the given directory
}

