package system.service.business;

import system.service.DAO.DatabaseConnector;
import system.service.DAO.SaleStaffDAO;

public class OrderRecorder implements SaleStaffOperation {

    private Order order;
    private String paymentMethod;
    private int totalPrice;
    private int totalDiscount;
    private String transactionDate;
    private int staffID;
    private int shopID;

    public OrderRecorder(Order order){
        this.order = order;
    }

    @Override
    public void operate() throws Exception {
        SaleStaffDAO saleStaffDAO = new SaleStaffDAO();
        saleStaffDAO.addOrder(paymentMethod, totalPrice, totalDiscount, transactionDate, staffID, shopID);
    }

    public void extracOrderData(){

    }
}
