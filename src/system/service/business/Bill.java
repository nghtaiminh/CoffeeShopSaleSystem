package system.service.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Bill {
    private static Order order;
    private List<Double> eachProductPayment;
    private double totalPayment;
    Bill(Order order){
        this.order = order;
        eachProductPayment = calculateEachProductPayment();
        totalPayment = calculateTotalPayment();
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

    private static double calculateTotalPayment(){
        HashMap<Product,Integer> orderList = order.getOrderList();
        double payment = 0;
        for(Product product : orderList.keySet()){
            int productQuantity = orderList.get(product);
            double productPrice = product.getPrice();
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
        System.out.println("Total payment " + totalPayment);
    }
}
