package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil{

    public static final String URL = "jdbc:mysql://localhost:3306/friend";
    public static final String USER = "user";
    public static final String PASSWORD = "standardUser";

    public static final Connection connection= getConnection();


    public static Connection getConnection(){
        if(connection == null) {
            try {
                Connection tempConnection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Connection Established to MYSQL Database");
                return tempConnection;
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return connection;
    }

    public static void showErrorMessage(SQLException e){
        System.err.println("Error :" + e.getMessage());
        System.err.println("Error code: " + e.getErrorCode());
    }

}