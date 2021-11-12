/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.haben.dvdlibrary.dao;
import com.haben.dvd.dto.DVD;
import java.util.List;

/**
 *
 * @author Haben
 */
public interface dvdLibraryDao {
    
        
    /**
     * Adds the given DVD to the file and associates it with the given
     * title. 
     *
     * @param title title associated with DVD
     * @param dvd dvd 
     * @return the Dvd object previously associated with the given  
     * Dvd id if it exists, null otherwise
     * @throws com.haben.dvdlibrary.dao.DvdDaoException
     */
    DVD addDVD(String title, DVD dvd) throws DvdDaoException;

    /**
     * Removes DVD from collection, the title associated with DVD
     * Returns the DVD object that is being removed or null if
     * there is no DVD associated with the given id
     * @param title
     * @return 
     * @throws com.haben.dvdlibrary.dao.DvdDaoException
     */
    DVD removeDVD(String title) throws DvdDaoException;
    
    /**
     * Gets the specific DVD and allows user to EDIT THE INFORMATION
     * 
     * @param editDVD
     * @param choice
     * @param replace
     * @return 
     * @throws com.haben.dvdlibrary.dao.DvdDaoException
     */
    public int editDVD(DVD editDVD, int choice, String replace) throws DvdDaoException;
    
    /**
     * Returns a List of all DVD's in collection.
     * @return 
     * @throws com.haben.dvdlibrary.dao.DvdDaoException
     */
    List<DVD> getAllDVD() throws DvdDaoException;
    
    /**
     * *****STEP 4!!!
     * Displays all information for particular movie based on title****
     * @param title
     * @return 
     * @throws com.haben.dvdlibrary.dao.DvdDaoException 
     */
    DVD searchDvd(String title) throws DvdDaoException;

    /**
     * Returns DVD object associated with DVD title name
     * Returns null if no such DVD exists
     *
     * @param title
     * @return 
     * @throws com.haben.dvdlibrary.dao.DvdDaoException
     */
    //searchDVD(String title) **ALT
    DVD getDVD(String title) throws DvdDaoException;

    public DVD getDvd(String dvdTitle);

   }
