/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DvdLibraryDao;
import com.sg.dvdlibrary.dao.DvdLibraryDaoFileImpl;
import com.sg.dvdlibrary.dto.Dvd;
import com.sg.dvdlibrary.ui.DvdLibraryView;
import java.util.List;

/**
 *
 * @author stwal
 */
public class DvdLibraryController {

   private final DvdLibraryView view = new DvdLibraryView();
   private final DvdLibraryDao dao = new DvdLibraryDaoFileImpl();
   
   public void run() {
       boolean keepGoing = true;
       int menuChoice = 0;
       
       while (keepGoing) {
           
           menuChoice = getMenuSelection();
           
           switch(menuChoice) {
               case 1 -> this.showAll();
               case 2 -> this.createDvd();
               case 3 -> this.viewDvd();
               case 4 -> this.removeDvd();
               case 5 -> this.editDvd();
               case 6 -> keepGoing = false;
               default -> this.unknownMsg();
            }  
       }
       this.displayExit();
   }

    private int getMenuSelection() {
        return view.printMenuGetChoice();
    }
    
    private void createDvd() {
        view.displayCreateDvdBanner();
        Dvd newD = view.getNewDvdInfo();
        
        dao.addDvd(newD.getTitle(), newD);
        
        view.displayCreateSuccessBanner();
    }
    
    private void showAll() {
        view.displayAllDvdBanner();
        
        List<Dvd> dvdL = dao.getAllDvds();
        
        view.displayDvds(dvdL);
    }
    
    private void viewDvd() {
        view.bannerShowDvd();
       
        String dTitle = view.getDvdTitle();
        
        Dvd dvd = dao.getDvd(dTitle);
        
        view.displayDvd(dvd);
    }
    
    private void removeDvd() {
        view.removeDvdBanner();
        
        String dTitle = view.getDvdTitle();
        
        Dvd dvd = dao.removeDvd(dTitle);
       
        view.removeDvdResults(dvd);
    }
    
    private void unknownMsg() {
        view.unknownMsg();
    }
    
    private void displayExit() {
        view.displayExit();
    }
   
    
    public void editDvd(){
        view.editDvdBanner();
        
        String dTitle = view.getDvdTitle();
        
        Dvd dEdit = dao.getDvd(dTitle);
        
        if (dEdit == null){
            view.displayNullTitle();
        } else {
            int menuSelection = 0;
            
            boolean keepGoing = true;
            
            while (keepGoing) {
               int userSelection = view.getEditMenuInput();
           
               switch (userSelection){
                   case 1:
                       editDirector();
                       break;
                   case 2:
                       editRating();
                       break;
                   case 3:
                       editStudio();
                       break;
                   case 4:
                       keepGoing = false;
                       break;
                   default: 
                       this.unknownMsg();
               
               }
               if (keepGoing == false) {
                   break;
               }
            }
        }
    }
    
    private void editRating(String title){
       
    }
    
    private void editDirector(String title){
       
    }
    
     private void editStudio(String title){
       
    }
}
