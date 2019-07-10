package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil{

    public static final String URL = "jdbc:mysql://localhost:3306/friend";
    public static final String USER = "user";
    public static final String PASSWORD = "standardUser";

    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection Established to MYSQL Database");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return connection;
    }

    public static void showErrorMessage(SQLException e){
        System.err.println("Error :" + e.getMessage());
        System.err.println("Error code: " + e.getErrorCode());
    }

//    public static void main(String[] args) {
//        Connection connection = getConnection();
//        System.out.println("Connected to database");
//    }

}