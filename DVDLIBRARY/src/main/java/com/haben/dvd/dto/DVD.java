/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.haben.dvd.dto;

/**
 *
 * @author Haben
 */
//This is the DTO that holds all the DVD info
public class DVD {
    private String title;
    private String releaseDate;
    private String mpaaRating;
    private String directorName;
    private String studio;
    private String userRating;
    
    //Title is the only read-only field
    //    public DVD(){
    //        
    //    }
    //Constructor that takes title as only parameter
    public DVD(String title){
        this.title = title;
    }
    
    //Getters/Setters for all the fields
    public String getTitle() {
        return title;
    }
    
//    public void setTitle(String title) {
//        this.title = title;
//    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }
    
    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }
    
    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }
    
    public String getUserRating() {
        return userRating;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }
    
}
