import daos.UserDao;
import models.DbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Runner {



    public static void main(String[] args) throws SQLException {

        UserDao run = new UserDao(DbUtil.getConnection());

    }

}
