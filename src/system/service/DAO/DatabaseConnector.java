package system.service.DAO;

import java.sql.Connection;

public interface DatabaseConnector {
    public Connection getConnection() throws Exception;
}
