package system.service.facade;

import java.util.List;
import system.service.DAO.GeneralManagerDAO;
import system.service.DAO.LocalManagerDAO;

public class GeneralManagerFacade extends LocalManagerFacade{

    private GeneralManagerDAO generalManagerDAO;

    public GeneralManagerFacade(){
         generalManagerDAO = new GeneralManagerDAO();
    }

    public void setGlobalPromotion(int productID, int discountPercentage,
                                   String startDate, String endDate, int managerID) throws Exception {
        List<Integer> listOfShopID = generalManagerDAO.getListOfShopID();
        var localManagerDAO = new LocalManagerDAO();
        for(Integer shopID : listOfShopID){
            localManagerDAO.setPromotion(productID, shopID, discountPercentage,
                    startDate, endDate, managerID);
        }
    }
}
