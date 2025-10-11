package org.example;
import java.io.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Dictionary {
    //Using a hash set to hold the list of words
    private HashSet<String> validWords;

    public Dictionary(String dictFilePath){
        validWords = new HashSet<>();
        fillDictionary(dictFilePath);
    }

    public void fillDictionary(String dictFilePath){
        try{
            File file = new File(dictFilePath);
            Scanner scnr = new Scanner(file);
            while(scnr.hasNextLine()){
                String word = scnr.nextLine().trim().toLowerCase();
                if(!word.isEmpty()){
                    validWords.add(word);
                }
            }
            scnr.close();
            System.out.println("Successfully added "+validWords.size()+" words into the dictionary.");

        }catch(FileNotFoundException e){
            System.err.println("The dictionary file could not be found");
        }
    }

    //Method to check if a word is contained in the dictionary list
    public boolean isInDictionary(String word){
        return validWords.contains(word.toLowerCase());
    }
}
