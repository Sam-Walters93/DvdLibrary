/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.Dvd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author stwal
 */
public class DvdLibraryDaoFileImpl implements DvdLibraryDao {

    /**
     * @param args the command line arguments
     */
   
    
    private Map<String, Dvd> dvds = new HashMap<>();

    
    @Override
    public Dvd addDvd(String title, Dvd dvd) {
        Dvd prevD = dvds.put(title, dvd); 
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
}
