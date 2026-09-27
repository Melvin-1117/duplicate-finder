package com.anton.dupfinder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;   //MessageDigest is a mechanism that is used to use algorithm, here sha-256 is used and message digest works Like an API
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
public class HashCalculator{
    public String calculateHash(Path filePath){
        try {
            byte[] fileBytes = Files.readAllBytes(filePath);
            MessageDigest digest = MessageDigest.getInstance("SHA-256");      //className.methodName(argument)
            digest.update(fileBytes);
            byte[] hashBytes = digest.digest();
            StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < hashBytes.length; i++) {
                hexString.append(String.format("%02x", hashBytes[i] & 0xFF));
            }
            return hexString.toString();
        }catch(IOException | NoSuchAlgorithmException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}