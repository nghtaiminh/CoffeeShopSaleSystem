package system.service.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import system.service.business.Employee;
import system.service.business.Product;

public class SaleStaffDAO {

    public void addOrder(String paymentMethod, int totalPrice, int totalDiscount, String transationDate, int staffID, int shopID) throws Exception {
        String query = "INSERT INTO [Order] (paymentMethod, totalPriceAfterDiscount, totoalDiscount, transactionDateTime, staffID, shopID) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnector.getInstance().getConnection()) {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, paymentMethod);
            ps.setString(2, String.valueOf(totalPrice));
            ps.setString(3, String.valueOf(totalDiscount));
            ps.setString(4, transationDate);
            ps.setString(5, String.valueOf(staffID));
            ps.setString(6, String.valueOf(shopID));
            
            int i = ps.executeUpdate();
            if (i > 0){
                System.out.println("Insert Order Successfully!");
            } else {
                System.out.println("Fail to Insert Order");
            }
            conn.close();
        }
        

    }
    
    public Employee authenticate(String email, String password) throws SQLException, Exception {
        String query = "SELECT * FROM Employee WHERE email = ? AND password = ?";
        String role = null;
        
        
        try (Connection conn = DatabaseConnector.getInstance().getConnection()) {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee(rs.getInt("employeeID"), rs.getString("firstName"), rs.getString("lastName"), rs.getInt("shopID"), rs.getInt("roleID"));
                System.out.println("Login sucessfully!");
                return employee;
            }
        }
        System.out.println("Incorect email/password!");                
        return null;
    }
    
    public boolean isProductAvailable(int productID, int shopID, int sellingQuantity) throws Exception {
        String query = "SELECT * FROM Inventory WHERE productID = ? AND shopID = ? AND quantity >= ? ";
        try (Connection conn = DatabaseConnector.getInstance().getConnection()) {
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, String.valueOf(productID));
            ps.setString(2, String.valueOf(shopID));
            ps.setString(3, String.valueOf(sellingQuantity));
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("The product is available");
                conn.close();
                return true;
            }
            System.out.println("The amount of product is not available in the inventory");
            conn.close();
            return false;
        }
    };
    
    public void updateInventory (String productID, String shopID, String sellingQuantity) throws Exception {
        String query = "UPDATE Inventory SET quantity += ? WHERE productID = ? AND shopID = ?";
        try (Connection conn = DatabaseConnector.getInstance().getConnection()) {
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, sellingQuantity);
            ps.setString(2, productID);
            ps.setString(3, shopID);
            int i = ps.executeUpdate();
            if (i > 0){
                System.out.println("Update Inventory Successfully!");
            } else {
                System.out.println("Fail to Update Inventory");
            }
            conn.close();
        }
    };
    
    public List<Product> getListOfProductByShopID(int shopID) throws Exception {
        String query = "SELECT DISTINCT Product.productID, productName, productCategory, retailPrice FROM Product , Inventory WHERE  shopID = ?;";
        List<Product> listOfProduct;
        try (Connection conn = DatabaseConnector.getInstance().getConnection()) {
            listOfProduct = null;
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, String.valueOf(shopID));
            ResultSet rs = ps.executeQuery(); 
           while (rs.next()){
                Product product = new Product(rs.getInt("productID"), rs.getString("productName"), rs.getString("productCategory"), rs.getInt("retailPrice"));
                listOfProduct.add(product);
            }
            conn.close();
        }
        return listOfProduct;     
    };
    
}
