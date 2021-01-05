package system.service.business;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;

public class Order {
    private Integer ID;
    private Date date;
    private HashMap<Product,Integer> orderList;
    private String shopLocation;

    public Order(String shopLocation){
        this.date = Date.valueOf(LocalDate.now());
        this.orderList = new HashMap<>();
        this.shopLocation = shopLocation;
    }

    public Date getdDate() {
        return date;
    }
    public HashMap<Product,Integer> getOrderList(){
        return orderList;
    }

    public String getShopLocation() {
        return shopLocation;
    }

    public void addOrder(Product product, int productQuantity) {
        this.orderList.put( product, productQuantity );
    }
}
