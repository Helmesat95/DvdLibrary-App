package DvdLibrary;


import com.haben.dvd.ui.DvdLibraryView;
import com.haben.dvd.ui.UserIo;
import com.haben.dvd.ui.UserIoConsoleImpl;
import com.haben.dvdlibrary.controller.DvdLibraryController;
import com.haben.dvdlibrary.dao.DvdLibraryDaoFileImpl;
import com.haben.dvdlibrary.dao.dvdLibraryDao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Haben
 */
public class App {
      public static void main(String[]  args){
        UserIo myIo = new UserIoConsoleImpl();
        DvdLibraryView myView = new DvdLibraryView(myIo);
        dvdLibraryDao myDao = new DvdLibraryDaoFileImpl();
        //Instantiating our controller and calling the run method
        DvdLibraryController controller = new DvdLibraryController(myDao, myView);
        controller.run();
    }
}
