/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.haben.dvdlibrary.controller;

import com.haben.dvd.ui.UserIo;
import com.haben.dvd.ui.DvdLibraryView;
import com.haben.dvd.ui.UserIoConsoleImpl;
import com.haben.dvd.dto.DVD;
import com.haben.dvdlibrary.dao.dvdLibraryDao;
import com.haben.dvdlibrary.dao.DvdDaoException;
import java.util.List;
/**
 *
 * @author Haben
 */
//

//This is the orchestrator of the application. It knows what needs
//to be done, when it needs to be done, and what component can do the job.
 public class DvdLibraryController {
    private UserIo io = new UserIoConsoleImpl();
    private DvdLibraryView view;
    private dvdLibraryDao dao;
    private String title;
  
    /**
     *
     * @param dao
     * @param view
     */
    //Dependency injection
    public DvdLibraryController(dvdLibraryDao dao,DvdLibraryView view) {
        this.dao = dao;
        this.view = view;
        
    }
    // Displaying Menu 
    
    public void run(){
        boolean keepRunning = true;
        int menuSelection = 0;
        try{
            while (keepRunning){
                
                 io.print("Main Menu");
                    io.print("1. Creat DVD ");
                    io.print("2. Remove DVD");
                    io.print("3. Edit DVD");
                    io.print("4. List DVDS");
                    io.print("5. View DVD");
                    io.print("6. Search DVD"); 
                    io.print("7. Exit");  
                    
                   
                    
                    menuSelection = io.readInt("Please select from the"
                      
                            + " above choices.", 1, 7);
               
                 menuSelection = getMenuSelection();
                 
                 switch (menuSelection){
                    
                    case 1:
                        createDVD();
                        break;
                    case 2:
                        removeDVD();
                        break;
                    case 3:
                        editDVD();
                        break;
                    case 4:
                        listDVDs();
                        break;
                    case 5:
                        viewDVD();
                        break;
                    case 6:
                        searchDVD();
                        break;
                    case 7:
                        keepRunning = false;
                        break;
                    default:
                        unknownCommand();
                        
                }
            }
          exitMessage();
        }catch (DvdDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
             
    }
   
    //Retrives menu selections from view
    private int getMenuSelection(){
        return view.printMenuAndGetSelection();   
    
    }
    
    private void createDVD() throws DvdDaoException{
        view.displayCreatDVDBanner();
        DVD newDvd = view.getDVDInfo();
        dao.addDVD(newDvd.getTitle(), newDvd);
        view.displayCreatSuccessBanner();
        
    }
    
    private void listDVDs() throws DvdDaoException {
        view.displayDisplayAllBanner();
        List<DVD> dvdList = dao.getAllDVD();
        view.displayDVDList(dvdList);
        
    }
    
    private void viewDVD()throws DvdDaoException{
        view.diplayDisplayDVDBanner();
        String dvdTitle = view.getDVDTitleChoice();
        DVD dvd = dao.getDVD(title);
        view.displayDVD(dvd);
    }
            
    
    private void removeDVD()throws DvdDaoException{
        view.displayRemoveDVDBanner();
        String dvdTitle = view.getDVDTitleChoise();
        DVD removedDVD = dao.removeDVD(dvdTitle);
        view.displayRemoveResult(removedDVD);
    }
    
    private void editDVD()throws DvdDaoException{
        view.displayEditDVDBanner();
        String dvdTitle = view. getDVDEditTitleChoice();
        DVD editDVD = dao.getDvd(dvdTitle);
        boolean change2 = view.displayEditResult(editDVD);
        if(change2){
            view.editMenu();
            int choice = view.editHelper();
            String replaceValue = view.getEditValue(choice);
            int result = dao.editDVD(editDVD, choice, replaceValue);
            view.displaySuccessEdit();
            
        }
        
    }
    private void searchDVD() throws DvdDaoException{
        view.displaySearchBanner();
        String title = view.getDVDTitleChoice();
        DVD dvd = dao.searchDvd(title);
        view.searchDvdResult(dvd);
        view.displayDVD(dvd);
    }
    private void unknownCommand(){
        view.displayUnknownCommandBanner();
        
    }
    private void exitMessage(){
        view.displayExitBanner();
    }

   
    
}
