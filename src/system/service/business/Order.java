package system.service.business;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;

public class Order {

    private int ID;
    private HashMap<Product,Integer> orderList;
    private Date date;
    private int shopID;

    public Order(int shopID){
        this.date = Date.valueOf(LocalDate.now());
        this.orderList = new HashMap<>();
        this.shopID = shopID;
    }


    public Date getdDate() {
        return date;
    }

    public HashMap<Product,Integer> getOrderList(){
        return orderList;
    }

    public Integer getShopID() {
        return shopID;
    }

    public void addOrder(Product product, int productQuantity) {
        this.orderList.put( product, productQuantity );
    }
}
