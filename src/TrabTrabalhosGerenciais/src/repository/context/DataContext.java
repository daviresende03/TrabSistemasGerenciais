package repository.context;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataContext {
    private final String URL = "jdbc:mysql://localhost:";
    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String PORT = "3307";
    private final String DATABASE = "";
    
    private Connection connection;
    
    public DataContext(){
        try {
            String finalUrl = URL + PORT + "/" + DATABASE;
            connection = DriverManager.getConnection(finalUrl, USER, PASSWORD);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Connection getConnection() {
        return connection;
    }
    
    public void commit() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void rollback() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
