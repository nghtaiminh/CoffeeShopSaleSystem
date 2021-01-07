/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.service.DAO;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

/**
 *
 * @author taiminh
 */
public class DatabaseConnector {
    private static DatabaseConnector instance = new DatabaseConnector();
    
    String connectionUrl = "jdbc:sqlserver://"
                    + "localhost:1433;"
                    + "databaseName=CoffeeShopSale;"
                    + "user=sa;"
                    + "password=12345";
    
    private Connection conn;
    
    public DatabaseConnector() {
    
    };
    public static DatabaseConnector getInstance() {
        return instance;
    };
    
    public void connect() throws SQLException, Exception {
        if (conn == null){
            try {
                conn = DriverManager.getConnection(connectionUrl);
            }
            catch (SQLException e) {
                throw new Exception ("Error connection Database", e);
            }
        }
    };
    
    public Connection getConnection() throws SQLException, Exception {
        connect();
        return conn;
    }
    
    public void close() throws SQLException {
        conn.close();
    }
    
}
