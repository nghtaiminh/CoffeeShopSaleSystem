package system.service.DAO;

import system.service.business.Order;
import system.service.business.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;

public class SaleStaffDAO {

    private DatabaseConnector databaseConnector;
    private Connection connection;

    public SaleStaffDAO(DatabaseConnector databaseConnector) throws Exception {
        this.databaseConnector = databaseConnector;
        this.connection = databaseConnector.getConnection();
    }

    public void addOrder(Order newOrder) throws Exception {

        String insertOrderSQL = "INSERT INTO CustomerOrder (ProductName, Quantity, Date, ShopLocation) " +
                "VALUES (?,?,?,?)";
        PreparedStatement insertOrder = connection.prepareStatement(insertOrderSQL);
        HashMap<Product,Integer> orderList = newOrder.getOrderList();
        for (Product aProduct : orderList.keySet()) {
            insertOrder.setString(1, aProduct.getName());
            insertOrder.setInt(2, orderList.get(aProduct));
            insertOrder.setDate(3,newOrder.getdDate());
            insertOrder.setString(4, newOrder.getShopLocation());
            insertOrder.executeUpdate();
        }
        connection.commit();
        connection.close();
    }

    /*public void insertOrder(String paymentMethod, String totalPrice, String totalDiscount, String transationDate, String staffID, String shopID) throws Exception {
        String query = "INSERT INTO [Order] (paymentMethod, totalPriceAfterDiscount, totoalDiscount, transactionDateTime, staffID, shopID) VALUES (?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DriverManager.getConnection(connectionUrl);
            ps = conn.prepareStatement(query);
            ps.setString(1, paymentMethod);
            ps.setString(2, totalPrice);
            ps.setString(3, totalDiscount);
            ps.setString(4, transationDate);
            ps.setString(5, staffID);
            ps.setString(6, shopID);

            System.out.println("Insert Order Successfully!");
        }
        catch (SQLException e) {
            throw new Exception("Error Insert Order", e);
        }
        finally {
            conn.close();
            ps.close();
        }
    }

    public boolean authenticate(String email, String password) throws SQLException, Exception {
        String query = "SELECT employeeID FROM Employee WHERE email = ? AND password = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DriverManager.getConnection(connectionUrl);
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("Login sucessfully!");
                conn.close();
                return true;
            }
            System.out.println("Incorect email/password!");
        }
        catch (SQLException e) {
            throw new Exception("Error Connecting Database", e);
        }
        finally {
            conn.close();
            ps.close();
        }
        return false;
    }*/
}
