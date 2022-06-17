/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.Dvd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author stwal
 */
public class DvdLibraryDaoFileImpl implements DvdLibraryDao {

    /**
     * @param args the command line arguments
     */
   
    
    private Map<String, Dvd> dvds = new HashMap<>();
    private final String DELIMITER = "::";
    private final String LIBRARY_FILE;
    
    
    public DvdLibraryDaoFileImpl() {
        LIBRARY_FILE = "DvdLibrary.txt";
    }
    
    public DvdLibraryDaoFileImpl(String libraryTextFile) {
        LIBRARY_FILE = libraryTextFile;
    }
 
    @Override
    public Dvd addDvd(String title, Dvd dvd) {
        loadLibrary();
        Dvd prevD = dvds.put(title, dvd); 
        writeLibrary();
        return prevD;
    }

    @Override
    public List<Dvd> getAllDvds() {
        return new ArrayList<Dvd>(dvds.values());
    }

    @Override
    public Dvd getDvd(String title) {
        return dvds.get(title);
    }

    @Override
    public Dvd removeDvd(String title) {
        Dvd removedTitle = dvds.remove(title); 
        return removedTitle;
    }

    @Override
    public Dvd editDvd(String title) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public Dvd changeRating(String title, String rating) {
        Dvd dvdToChange = dvds.get(title);
        dvdToChange.setRating(rating);
        return dvdToChange;
    }
    
    @Override
    public Dvd changeDirector(String title, String name) {
        Dvd dvdToChange = dvds.get(title);
        dvdToChange.setDirector(name);
        return dvdToChange;
    }
    
    @Override 
    public Dvd changeStudio(String title, String studio) {
        Dvd dvdToChange = dvds.get(title);
        dvdToChange.setStudio(studio);
        return dvdToChange;
    }
    
    @Override 
    public Dvd changeDate(String title, String date) {
        Dvd dvdToChange = dvds.get(title);
        dvdToChange.setReleaseDate(date);
        return dvdToChange;
    }
    
    private void loadLibrary() {
        
        Scanner scanner = new Scanner(System.in);
        
        try {
            
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
           
        }
        
        String currentLine;
        Dvd currentDvd;
       
        while (scanner.hasNextLine()) {
            
            currentLine = scanner.nextLine();
           
            currentDvd = unmarshallDvd(currentLine);
            
            
            dvds.put(currentDvd.getTitle(),currentDvd);
        }
        scanner.close();
    }
    
    private void writeLibrary() {
   
        PrintWriter out;
        String dvdAsText;
        List <Dvd> dvdList = this.getAllDvds();

        try {
            out = new PrintWriter(new FileWriter(LIBRARY_FILE));
            
            for (Dvd currentDvd : dvdList) {

                dvdAsText = marshallDvd(currentDvd);

                out.println(dvdAsText);

                out.flush();   
            }
            out.close();
        } catch (IOException e) {
            //handle 
        }
        
    }
    
    
    private String marshallDvd(Dvd dvd) {
        String dvdAsText = dvd.getTitle() + DELIMITER;
        dvdAsText += dvd.getReleaseDate() + DELIMITER;
        dvdAsText += dvd.getDirector() + DELIMITER;
        dvdAsText += dvd.getRating() + DELIMITER;
        dvdAsText += dvd.getStudio();
        return dvdAsText;
    }
    
    
    private Dvd unmarshallDvd(String dvdAsText) {
        
        String [] dvdTokens = dvdAsText.split(DELIMITER);
     
        String title = dvdTokens[0];
        String releaseDate = dvdTokens[1];
        String mpaaRating = dvdTokens[2];
        String directorName = dvdTokens[3];
        String studio = dvdTokens[4];
        
     
        Dvd dvdFromFile = new Dvd(title);
        dvdFromFile.setReleaseDate(releaseDate);
        dvdFromFile.setRating(mpaaRating);
        dvdFromFile.setDirector(directorName);
        dvdFromFile.setStudio(studio);
        return dvdFromFile;
    }
}
