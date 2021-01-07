package system.service.facade;

import system.service.DAO.*;

public class LocalManagerFacade extends SaleStaffFacade{

    private LocalManagerDAO localManagerDAO;

    public LocalManagerFacade(){
        this.localManagerDAO = new LocalManagerDAO();
    }

    public void report(int shopID, String date) throws Exception{
        System.out.println(localManagerDAO.totalOrderOfADay(shopID, date));
        System.out.println(localManagerDAO.totalRvenueOfADay(shopID, date));
    }

    public void setLocalPromotion(){
//        localManagerDAO.setPromotion();
    }
}
