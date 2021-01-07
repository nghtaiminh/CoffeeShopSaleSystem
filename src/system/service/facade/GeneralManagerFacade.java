package system.service.facade;

import system.service.DAO.GeneralManagerDAO;

public class GeneralManagerFacade extends LocalManagerFacade{

    private GeneralManagerDAO generalManagerDAO;

    public GeneralManagerFacade(){
         generalManagerDAO = new GeneralManagerDAO();
    }

    public void setGlobalPromotion(){
    }
}
