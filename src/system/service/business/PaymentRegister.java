package system.service.business;

import system.service.DAO.SaleStaffDAO;

public class PaymentRegister implements SaleStaffOperation{

    private String productID;
    private String shopID;
    private String sellingQuantity;

    public PaymentRegister(String productID, String shopID, String sellingQuantity) {
        this.productID = productID;
        this.shopID = shopID;
        this.sellingQuantity = sellingQuantity;
    }

    @Override
    public void operate() throws Exception {
        SaleStaffDAO saleStaffDAO = new SaleStaffDAO();
        saleStaffDAO.updateInventory(productID, shopID, sellingQuantity);
    }
}
