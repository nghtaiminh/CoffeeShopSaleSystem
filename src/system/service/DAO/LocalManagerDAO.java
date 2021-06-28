/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.service.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author taiminh
 */
public class LocalManagerDAO {
    
    public int totalOrderOfADay(int shopID, String date) throws Exception {
        String query = "SELECT COUNT(*) FROM [Order] WHERE shopID = ? AND FORMAT(transactionDatetime, 'dd/MM/yyyy') = ?";
        Connection conn = DatabaseConnector.getInstance().getConnection();
        int nOrder = 0;
        PreparedStatement ps  = conn.prepareStatement(query);
        ps.setString(1, String.valueOf(shopID));
        ps.setString(2, date);
        
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            nOrder = ((Number) rs.getObject(1)).intValue();
        }
        return nOrder;
    }
    
    public int totalRvenueOfADay(int shopID, String date) throws Exception {
        String query = "SELECT SUM(totalPriceAfterDiscount) FROM [Order] WHERE shopiD = ?  AND FORMAT(transactionDatetime, 'dd/MM/yyyy') = ?";
        Connection conn = DatabaseConnector.getInstance().getConnection();
        int totalRevenue = 0;
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, String.valueOf(shopID));
        ps.setString(2, date);
        
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            totalRevenue = ((Number) rs.getObject(1)).intValue();
        }
        return totalRevenue;
    }
    
    public void addProduct(String productName, String productCategory, String measureUnit, int cost, int retailPrice) throws Exception {
        String query = "INSERT INTO Product (productName, productCategory, measureUnit, cost, retailPrice) VALUES (?, ?, ?, ?, ?);";
        try (Connection conn = DatabaseConnector.getInstance().getConnection()) {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, productName);
            ps.setString(2, productCategory);
            ps.setString(3, measureUnit);
            ps.setString(4, String.valueOf(cost));
            ps.setString(5, String.valueOf(retailPrice));
            
            int i = ps.executeUpdate();
            if (i > 0){
                System.out.println("Update Inventory Successfully!");
            } else {
                throw new Exception("Fail to Update Inventory");
            }
            conn.close();
        }
        
    };
    
    public void setPromotion(int productID, int shopID, int discountPercentage, String startDate, String endDate, int managerID) throws Exception {
        String query = "INSERT INTO Promotion (productID, shopID, discountPercentage, startDate, endDate, managerID) VALUES (?, ?, ?, ?, ?, ?);";
        try (Connection conn = DatabaseConnector.getInstance().getConnection()) {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, String.valueOf(productID));
            ps.setString(2, String.valueOf(shopID));
            ps.setString(3, String.valueOf(discountPercentage));
            ps.setString(4, startDate);
            ps.setString(5, endDate);
            ps.setString(6, String.valueOf(managerID));
            
            int i = ps.executeUpdate();
            
            if (i > 0) {
                System.out.println("Insert Promotion Successsfully");
            } else {
                throw new Exception("Fail to Insert to Promotion");
            }
            conn.close();
        }
    }
        
}
