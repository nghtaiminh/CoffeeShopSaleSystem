package system.service.facade;

import system.service.DAO.*;

public class LocalManagerFacade extends SaleStaffFacade{

    private LocalManagerDAO localManagerDAO;

    public LocalManagerFacade(){
        this.localManagerDAO = new LocalManagerDAO();
    }

    public void report(){
        System.out.println(localManagerDAO.totalOrderOfADay());
        System.out.println(localManagerDAO.totalRvenueOfADay());
    }

    public void setLocalPromotion(){
        localManagerDAO.setPromotion();
    }
}
