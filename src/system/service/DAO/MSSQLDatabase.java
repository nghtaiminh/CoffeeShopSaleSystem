/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.service.DAO;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;

/**
 *
 * @author taiminh
 */
public class MSSQLDatabase implements DatabaseConnector {
    private final String connectionUrl = "jdbc:sqlserver://"
            + "localhost:1433;"
            + "databaseName=CoffeeShopSale;"
            + "user=SA;"
            + "password=Ty Chuot 1998";

    @Override
    public Connection getConnection() throws SQLException, Exception {
        try {
            return DriverManager.getConnection(connectionUrl);
        } catch (SQLException e) {
            throw new Exception("Error connection Database", e);
        }
    }
}
