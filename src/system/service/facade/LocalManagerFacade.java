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

    public void setLocalPromotion(int productID, int shopID, int discountPercentage,
                                  String startDate, String endDate, int managerID) throws Exception {
        localManagerDAO.setPromotion(productID, shopID, discountPercentage,
                startDate, endDate, managerID);
    }
}
