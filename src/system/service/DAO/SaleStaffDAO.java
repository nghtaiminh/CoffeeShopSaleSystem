package system.service.DAO;

import system.service.business.Order;
import system.service.business.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SaleStaffDAO {

    public void addOrder(String paymentMethod, String totalPrice, String totalDiscount, String transationDate, String staffID, String shopID) throws Exception {
        String query = "INSERT INTO [Order] (paymentMethod, totalPriceAfterDiscount, totoalDiscount, transactionDateTime, staffID, shopID) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnector.getInstance().getConnection()) {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, paymentMethod);
            ps.setString(2, totalPrice);
            ps.setString(3, totalDiscount);
            ps.setString(4, transationDate);
            ps.setString(5, staffID);
            ps.setString(6, shopID);
            
            int i = ps.executeUpdate();
            if (i > 0){
                System.out.println("Insert Order Successfully!");
            } else {
                System.out.println("Fail to Insert Order");
            }
            conn.close();
        }
        

    }

    public String authenticate(String email, String password) throws SQLException, Exception {
        String query = "SELECT * FROM Employee WHERE email = ? AND password = ?";
        String role = null;
        
        
        try (Connection conn = DatabaseConnector.getInstance().getConnection()) {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                role = rs.getString("roleID");
                System.out.println("Login sucessfully!");
                System.out.println(role);
                return role;
            }
        }
        System.out.println("Incorect email/password!");      
        return role;           
    }
    
    public boolean isProductAvailable(String productID, String shopID, String sellingQuantity) throws Exception {
        String query = "SELECT * FROM Inventory WHERE productID = ? AND shopID = ? AND quantity >= ? ";
        try (Connection conn = DatabaseConnector.getInstance().getConnection()) {
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, productID);
            ps.setString(2, shopID);
            ps.setString(3, sellingQuantity);
            
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
    
    
    
    
    public static void main(String args[]) throws SQLException, Exception {
        SaleStaffDAO stDAO = new SaleStaffDAO();
        stDAO.updateInventory("1", "1", "10");
    };
 
}
