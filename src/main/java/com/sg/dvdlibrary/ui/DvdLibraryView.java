/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.sg.dvdlibrary.ui;

import com.sg.dvdlibrary.dto.Dvd;
import java.util.List;

/**
 *
 * @author stwal
 */
public class DvdLibraryView {
    private UserIO io = new UserIOConsoleImpl();
    /**
     * @param args the command line arguments
     */
    public int printMenuGetChoice() {
        io.print("***MAIN MENU***");
           io.print("1. List DVDs");
           io.print("2. Enter new DVD");
           io.print("3. View a DVD");
           io.print("4. Remove a DVD");
           io.print("5. Edit a DVD");
           io.print("6. Exit");
           
           return io.readInt("Choose number from above", 1, 6);
    }
    
    public Dvd getNewDvdInfo() {
        String title = io.readString("Please enter title");
        String releaseDate = io.readString("Please Enter release date (just year is fine)");
        String rating = io.readString("Please enter MPAA rating");
        String director = io.readString("Please enter director's name");
        String studio = io.readString("Please enter producing studio");
        String note = io.readString("Any notes about the film?");
        
//        System.out.println(title +" " + releaseDate);
        
        Dvd currentDvd = new Dvd(title);
        currentDvd.setReleaseDate(releaseDate);
        currentDvd.setRating(rating);
        currentDvd.setDirector(director);
        currentDvd.setStudio(studio);
        currentDvd.setNote(note);
//        System.out.println(currentDvd.getTitle() +" " + currentDvd.getReleaseDate() + "con");
        return currentDvd;
    }
    
    public void displayCreateDvdBanner() {
        io.print("-----------ADD DVD-------------");
    }
    
    public void displayCreateSuccessBanner(){
        io.readString("DVD sucessfully added! Please hit enter to continue");
    }
    
    public void displayDvds(List<Dvd> dList) {
        for(Dvd dvd : dList) {
            String dvdInfo = String.format("%s : %s %s (%s)", 
                    dvd.getTitle(),
                    dvd.getReleaseDate(),
                    dvd.getDirector(),
                    dvd.getRating(),
                    dvd.getNote()
                    );
            
            io.print(dvdInfo);
        }
        
        io.readString("Hit enter to continue");
    }
    
    public void displayAllDvdBanner() {
        io.print("-----------DISPLAY ALL DVDS-------------");
    }
    
    public void bannerShowDvd() {
    io.print("-----------DISPLAY DVD-------------");
    }
    
    public String getDvdTitle() {
        return io.readString("Please enter title you are looking for");
    }
    
    public void displayDvd (Dvd dvd) {
        if (dvd != null) {
            io.print(dvd.getTitle());
            io.print(dvd.getReleaseDate());
            io.print(dvd.getDirector());
            io.print(dvd.getRating());
            io.print(dvd.getStudio());
            io.print(dvd.getNote());
        } else {
            io.print("This title does not appear to be in your library");
        }
        
        io.readString("Hit enter to continue");
    }
    
    public void removeDvdBanner() {
        io.print("-----------REMOVE A DVD-------------");
    }
    
    public void removeDvdResults(Dvd dvd) {
        if (dvd != null) {
            io.print("Title removed from Library");
        } else {
            io.print("This title does not appear to be in your library");
        }
        
        io.readString("Hit enter to continue");
    }
    
    public void editDvdBanner() {
        io.print("-----------EDIT A DVD-------------");
    }
    
    public void displayNullTitle(){
        io.print("No such title found in your library");
    }
    
    public void unknownMsg() {
        io.print("Unknown Input");
    }
    
    public void displayExit() {
        io.print("Goodbye");
    }
    
    public String getRating() {
        return io.readString("Please enter new MPAA rating");
    }
    
     public String getReleaseDate() {
        return io.readString("Please enter new release date");
    }
    
    public void displayEditResults() {
        io.print("-----------TITLE EDITED-------------");
    }
    
    public String getDirectorName() {
        return io.readString("Please enter new Director Name");
    }
    
    public String getStudioName() {
        return io.readString("Please enter new Studio");
    }
    public int getEditMenuInput() {
        io.print("Which field do you want to change?");
        io.print("Edit DVD menu");
        io.print("1. Director's Name");
        io.print("2. Release Date");
        io.print("3. MPAA rating");
        io.print("4. Studio name");
        io.print("5. Exit edit menu");
        return io.readInt("Please select from the above choices.", 1,5);
    }    
}
