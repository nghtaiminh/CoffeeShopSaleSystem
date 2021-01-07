package system.service.business;

import system.service.DAO.DatabaseConnector;
import system.service.DAO.SaleStaffDAO;

public class OrderRecorder implements SaleStaffOperation {

    @Override
    public void operate(Order order) throws Exception {
        DatabaseConnector mssqlDatabase = new DatabaseConnector();
        SaleStaffDAO saleStaffDAO = new SaleStaffDAO();
        
        System.out.println("Store this order into the Database");
        order.toString();
    }
}
