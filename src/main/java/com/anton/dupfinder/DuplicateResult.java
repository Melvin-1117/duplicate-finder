package com.anton.dupfinder;
import java.nio.file.Path;
import java.util.List;
public class DuplicateResult {
    private String hash;
    private List<Path> files;
    private Path selectedFile;
    private List<Path> deletedFiles;
    public DuplicateResult(String hash, List<Path> files,Path selectedFile,List<Path> deletedFiles){
        this.hash=hash;
        this.files=files;
        this.selectedFile=selectedFile;
        this.deletedFiles=deletedFiles;

    }
    public String getHash() {
        return hash;
    }
    public List<Path> getFiles(){
        return files;
    }
    public Path getSelectedFile(){
        return selectedFile;
    }
    public List<Path> getDeletedFiles(){
        return deletedFiles;
    }
}
