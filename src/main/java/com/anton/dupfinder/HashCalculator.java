package com.anton.dupfinder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;   //MessageDigest is a mechanism that is used to use algorithm, here sha-256 is used and message digest works Like an API
import java.io.IOException;
import java.security.NoSuchAlgorithmException;   // this particular import is for java messageDigest exception handling
public class HashCalculator{
    public String calculateHash(Path filePath){
        try {
            byte[] fileBytes = Files.readAllBytes(filePath);                           // this line is responsible for reading the file and retrun a byte array
            MessageDigest digest = MessageDigest.getInstance("SHA-256");      // this line is responsible for creating messageDigest object to use SHA-256 algorithm.
            digest.update(fileBytes);                                                  // it digest the input and converts into the format required for hashing algorithm
            byte[] hashBytes = digest.digest();                                        // it gives the required byte array to perform the hash conversion
            StringBuilder hexString = new StringBuilder();                             // StringBuilders are used to create a mutable string characters
            for (int i = 0; i < hashBytes.length; i++) {
                hexString.append(String.format("%02x", hashBytes[i] & 0xFF));          // here the resultant hash is being built and "%02x" is used to convert the hexadecimal in 2 character format and 0xFF this is used to convert the string in unsigned byte value
            }
            return hexString.toString();                                                //returns the resultant hash values
        }catch(IOException | NoSuchAlgorithmException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
/*
1) HashCalculator takes a file path, reads the file bytes, processes them using SHA-256, and generates a 32-byte hash.
2) It converts those hash bytes into a 64-character hexadecimal String and returns it to the caller.
 */
