/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.Dvd;
import java.util.List;

/**
 *
 * @author stwal
 */
public interface DvdLibraryDao {
    Dvd addDvd(String title, Dvd dvd);
    
    List<Dvd> getAllDvds();
    
    Dvd getDvd(String title);
    
    Dvd removeDvd(String title);
    
    Dvd editDvd(String title);
}
