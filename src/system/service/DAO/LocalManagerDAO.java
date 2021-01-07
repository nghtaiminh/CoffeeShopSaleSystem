/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.service.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author taiminh
 */
public class LocalManagerDAO {
    
    public int totalOrderOfADay(String shopID, String date) throws Exception {
        String query = "SELECT COUNT(*) FROM [Order] WHERE shopiD = ? AND FORMAT(transactionDatetime, 'dd/MM/yyyy') = ?";
        Connection conn = DatabaseConnector.getInstance().getConnection();
        int nOrder = 0;
        PreparedStatement ps  = conn.prepareStatement(query);
        ps.setString(1, shopID);
        ps.setString(2, date);
        
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            nOrder = ((Number) rs.getObject(1)).intValue();
        }
        return nOrder;
    }
    
    public int totalRvenueOfADay(String shopID, String date) throws Exception {
        String query = "SELECT SUM(totalPriceAfterDiscount) FROM [Order] WHERE shopiD = ?  AND FORMAT(transactionDatetime, 'dd/MM/yyyy') = ?";
        Connection conn = DatabaseConnector.getInstance().getConnection();
        int totalRevenue = 0;
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, shopID);
        ps.setString(2, date);
        
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            totalRevenue = ((Number) rs.getObject(1)).intValue();
        }
        return totalRevenue;
    }
    
    public void addProduct(String productName, String productCategory, String measureUnit, String cost, String retailPrace) throws Exception {
        String query = "INSERT INTO Product (productName, productCategory, measureUnit, cost, retailPrice) VALUES (?, ?, ?, ?, ?);";
        try (Connection conn = DatabaseConnector.getInstance().getConnection()) {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, productName);
            ps.setString(2, productCategory);
            ps.setString(3, measureUnit);
            ps.setString(4, cost);
            
            int i = ps.executeUpdate();
            if (i > 0){
                System.out.println("Update Inventory Successfully!");
            } else {
                System.out.println("Fail to Update Inventory");
            }
        }
        
    };
    
    public void setPromotion(String productID, String shopID, String discountPercentage, String startDate, String endDate, String managerID) throws Exception {
        String query = "INSERT INTO Promotion (productID, shopID, discountPercentage, startDate, endDate, managerID) VALUES (?, ?, ?, ?, ?, ?);";
        try (Connection conn = DatabaseConnector.getInstance().getConnection()) {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, productID);
            ps.setString(2, shopID);
            ps.setString(3, discountPercentage);
            ps.setString(4, startDate);
            ps.setString(5, endDate);
            ps.setString(6, managerID);
            
            int i = ps.executeUpdate();
            
            if (i > 0) {
                System.out.println("Insert Promotion Successsfully");
            } else {
                System.out.println("Fail to Insert to Promotion");
            }
        }
    }
    
    public static void main(String args[]) throws SQLException, Exception {
        LocalManagerDAO lmDAO = new LocalManagerDAO();
        int nOrder = lmDAO.totalRvenueOfADay("1", "03/01/2021");
        System.out.println(nOrder);
    };
    
}
