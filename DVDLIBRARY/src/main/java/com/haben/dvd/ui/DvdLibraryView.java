/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.haben.dvd.ui;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import com.haben.dvd.dto.DVD;

/**
 *
 * @author Haben
 */
public class DvdLibraryView {
    
    //Dependency injection 
    // instead of using UserIO io = new UserIoConsoleImpl();
    
    private UserIo io;
    public String get;
    public DvdLibraryView(UserIo io) {
        this.io = io;
    }
    
    //prints the menu options, get called controller.
    public int printMenuAndGetSelection(){
          io.print("Main Menu");
                    io.print("1. Creat DVD ");
                    io.print("2. Remove DVD");
                    io.print("3. Edit DVD");
                    io.print("4. List DVDS");
                    io.print("5. View DVD");
                    io.print("6. Search DVD"); 
                    io.print("7. Exit");  
                    
          return io.readInt("Please select from the"
                    + " above choices.", 1, 7);
    
        
    }
     public DVD getDVDInfo() {
        String movieTitle = io.readString("Please enter Movie Title");
        //IF TIME FORMAT DATE
        String releaseDate = io.readString("Please enter the Release Date");
        String mpaaRating = io.readString("Please enter MPAA Rating");
        String directorName = io.readString("Please enter Director's Name");
        String studio = io.readString("Please enter the name of the Studio");
        String userRating = io.readString("Please enter User Rating or any additional findings on the movie");
        DVD currentDVD = new DVD(movieTitle);
        currentDVD.setReleaseDate(releaseDate);
        currentDVD.setMpaaRating(mpaaRating);
        currentDVD.setDirectorName(directorName);
        currentDVD.setStudio(studio);
        currentDVD.setUserRating(userRating);
        return currentDVD;
    }
      public void displayCreatDVDBanner() {
         io.print("=== Add DVD ===");
    }

    public void displayCreatSuccessBanner() {
         io.readString("DVD successfully added.  Please hit enter to continue");
    }

       
  
            public void displayDVDList(List<DVD> dvdList) {
        boundary();
        dvdList.stream().map(currentDVD -> String.format("Title: %s\n"
                + "Release Date: %s\n"
                + "MPAA Rating: %s\n"
                + "Director's Name: %s\n"
                + "Studio: %s\n"
                + "User Rating: %s",
                currentDVD.getTitle(),
                currentDVD.getReleaseDate(),
                currentDVD.getMpaaRating(),
                currentDVD.getDirectorName(),
                currentDVD.getStudio(),
                currentDVD.getUserRating())).map(dvdInfo -> {
                    io.print(dvdInfo);
            return dvdInfo;
        }).forEachOrdered(item -> {
            boundary();
        });
        io.readString("Please hit enter to continue.");        
        }
    public void displayDisplayAllBanner() {
        io.print("=== Display All DVD's ===");
    }
    
    public void diplayDisplayDVDBanner() {
        io.print("=== Display DVD ===");
    }

     public String getDVDTitleChoise() {
       return io.readString("Please enter the DVD Title: "); 
    }
     public void displayDVD(DVD currentDVD) {
        if (currentDVD != null) {
            boundary();
            io.print("Title: " + currentDVD.getTitle());
            io.print("Release Date: " + currentDVD.getReleaseDate());
            io.print("MPAA Rating: " + currentDVD.getMpaaRating());
            io.print("Director's Name: " + currentDVD.getDirectorName());
            io.print("Studio: " + currentDVD.getStudio());
            io.print("User Rating: " + currentDVD.getUserRating());
            boundary();
        } else {
            io.print("DVD is not available.");
        }
        io.readString("Please hit enter to continue.");
    }
       public void displayRemoveDVDBanner(){
        io.print("=== Remove DVD ===");
    }

    public void displayRemoveResult(DVD dvd) {
        if(dvd != null){
          io.print("DVD removed successfully.");
        }else{
          io.print("DVD is not available.");
        }
        io.readString("Please hit enter to continue.");
    }
      public void displayEditDVDBanner () {
        io.print("=== Edit DVD ===");
    }
    
    public boolean displayEditResult(DVD dvd) {
        if(dvd != null){
          io.print(dvd.getTitle() + " Selected");
          return true;
        }
          io.print("DVD is not available.");
          io.readString("Please hit enter to continue.");
          return false;
    }
    
  
     public String getDVDEditTitleChoice() {
        return io.readString("Please enter the DVD Title You want to Edit: ");
        //String title = io.readString("Please enter the DVD Title to be Edited: ");
    }
    
    public void editMenu(){
        io.print("=== Edit Options ===");
        io.print("1. Edit Release Date");
        io.print("2. Edit MPAA Rating");
        io.print("3. Edit Director's Name");
        io.print("4. Edit Studio");
        io.print("5. Edit User Rating");
        
    }
      public int editMovie(){
        int editSelectedNumber = 0;
        int input = io.readInt("Please enter which movie option you want to change: ");
        switch (input) {
            case 1:
                io.print("Release Date");
                editSelectedNumber= 1;
                break;
            case 2:
                io.print("MPAA Rating");
                editSelectedNumber = 2;
                break;
            case 3:
                io.print("Director's Name");
                editSelectedNumber = 3;
                break;
            case 4:
                io.print("Studio");
                editSelectedNumber= 4;
                break;
            case 5:
                io.print("User Rating");
                editSelectedNumber = 5;
                //Editing nad making chages options 
                break;
            default:
                break;
        }
        
        return editSelectedNumber;
    }
    
    public String getEditValue(int editSelectedNumber){
        String replace = null;
          switch (editSelectedNumber) {
              case 1:
                  replace = io.readString("Please choose new Release Date to be?");
                  break;
              case 2:
                  replace = io.readString("Please choose new MPAA Rating to be?");
                  break;
              case 3:
                  replace = io.readString("Please choose new Director's Name to be?");
                  break;
              case 4:
                  replace = io.readString("Please choose new Studio Name to be?");
                  break;
              case 5:
                  replace = io.readString("Please choose new User Rating to be?");
                  //
                  break;
              default:
                  break;
          }
        return replace;
        
    }
    
    public void displaySuccessEdit(){
        io.print("DVD successfully edited. Please hit enter to continue");
    }
    
    public void displaySearchBanner() {
        io.print("=== Search DVD ===");
    }

    public void searchDvdResult(DVD dvd) {
        if (dvd != null) {
            io.print("DVD is stored in system");
            boundary();
        } else {
            io.print("DVD is NOT stored in system");
        }
    }
      public String getDVDTitleChoice() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public int editHelper() {
        throw new UnsupportedOperationException("Not supported yet.");     }
    
    public void displayExitBanner(){
        io.print("Have a nice day!!!");
    }

    public void displayUnknownCommandBanner(){
        io.print("Unknown Command!!!");
    }
    
    public void displayErrorMessage(String errorMsg) {
        io.print("=== Error ===");
        io.print(errorMsg);
    }
    
    public void boundary(){
        io.print("=======================");
    }

 
  
    }

