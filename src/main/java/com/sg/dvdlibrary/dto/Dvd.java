/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.dvdlibrary.dto;

import java.util.Objects;

/**
 *
 * @author stwal
 */
public class Dvd {
    
    private String title;
    private String releaseDate;
    private String rating;
    private String director;
    private String studio;
    private String note;
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.title);
        hash = 31 * hash + Objects.hashCode(this.releaseDate);
        hash = 31 * hash + Objects.hashCode(this.rating);
        hash = 31 * hash + Objects.hashCode(this.director);
        hash = 31 * hash + Objects.hashCode(this.studio);
        return hash;
    }

    public Dvd(String title) {
        this.title = title;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
     public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    } 
    
}
