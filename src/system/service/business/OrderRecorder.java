package system.service.business;

import system.service.DAO.DatabaseConnector;
import system.service.DAO.MSSQLDatabase;
import system.service.DAO.SaleStaffDAO;

public class OrderRecorder implements SaleStaffOperation {

    @Override
    public void operate(Order order) throws Exception {
        DatabaseConnector mssqlDatabase = new MSSQLDatabase();
        SaleStaffDAO saleStaffDAO = new SaleStaffDAO(mssqlDatabase);
        saleStaffDAO.addOrder(order);
        System.out.println("Store this order into the Database");
        order.toString();
    }
}
