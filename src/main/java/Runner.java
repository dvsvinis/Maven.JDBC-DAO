import daos.*;
import models.*;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Runner {

    public static void main(String[] args) throws SQLException {

  //      UserDao run = new UserDao(DbUtil.getConnection());

        //Test Create user
        Connection connection = DbUtil.getConnection();
        UserDao userDao = new UserDao(connection);
        User user = new User(12, "Walt","Disney", "wdisney@disney.com", "Orland", "FL", "12345");
        userDao.create(user);
        connection.close();

    }

}
