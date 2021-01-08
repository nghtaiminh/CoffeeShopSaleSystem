/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.service.DAO;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author taiminh
 */
public class GeneralManagerDAO {
    
    public List getListOfShopID() throws SQLException, Exception {
        String query = "SELECT shopID FROM Shop;";
        Connection conn = DatabaseConnector.getInstance().getConnection();
        List listOfID = null;
        
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            listOfID.add(rs.getInt("shopID"));
        }
        conn.close();
        return listOfID;   
    };

}
