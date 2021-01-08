package system.service.business;

import system.service.DAO.SaleStaffDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Bill {
    private static Order order;
    private List<Double> eachProductPayment;
    private Integer totalPrice;
    private int totalDiscount;

    public Bill(Order order){
        this.order = order;
        eachProductPayment = calculateEachProductPayment();
        totalPrice = calculateTotalPrice();
    }

    private static void getTotalDiscount(Product productID) throws Exception {
        Integer totalDiscount = 0;
        var saleStaffDAO = new SaleStaffDAO();
        Integer currentShopID = order.getShopID();
        List<Product> listOfProductInTheOrder = saleStaffDAO.getListOfProductByShopID(currentShopID);
        for(Product aProduct : listOfProductInTheOrder){

        }
    }

    private static List<Double> calculateEachProductPayment(){
        HashMap<Product,Integer> orderList = order.getOrderList();
        List<Double> eachProductPayment = new ArrayList<>();
        for(Product product : orderList.keySet()){
            int productQuantity = orderList.get(product);
            double productPrice = product.getPrice();
            eachProductPayment.add(productPrice*productQuantity);
        }
        return eachProductPayment;
    }

    private static Integer calculateTotalPrice(){
        HashMap<Product,Integer> orderList = order.getOrderList();
        Integer payment = 0;
        for(Product product : orderList.keySet()){
            int productQuantity = orderList.get(product);
            Integer productPrice = product.getPrice();
            payment = payment + productPrice*productQuantity;
        }
        return payment;
    }

    public void printBill(){
        HashMap<Product,Integer> orderList = order.getOrderList();
        int index = 0; // to get product payment
        for(Product product: orderList.keySet()){
            int productQuantity = orderList.get(product);
            double productPayment = eachProductPayment.get(index);
            System.out.println(product.getName() +" , "+ productQuantity+" , "+ productPayment );
        }
        System.out.println("Total payment " + totalPrice);
    }
}
