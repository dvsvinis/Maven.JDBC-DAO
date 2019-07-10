import daos.*;
import models.*;


import javax.sound.midi.Instrument;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Runner {

    public static void main(String[] args) throws SQLException {

        UserDao run = new UserDao(DbUtil.getConnection());

        //Test Create user
//        Connection connection = DbUtil.getConnection();
//        UserDao userDao = new UserDao(connection);
//        User user = new User(12, "Walt","Disney", "wdisney@disney.com", "Orland", "FL", "12345");
//        userDao.create(user);
//        connection.close();

        //Test findById
 //       System.out.println(run.findById(3).toString());

        //Test findAll()
//        Connection connection = DbUtil.getConnection();
//        UserDao userDao = new UserDao(connection);
//        List<User> allUsers = userDao.findAll();
//        for (User i : allUsers) {
//            System.out.println(i.toString());
//        }

        //Test update()
//        User user = run.findById(3);
//        user.setCity("Hollywood");
//        User updatedUser = run.update(user);
//        System.out.println("User updated");

        //Test delete()
        run.delete(12);
        System.out.println("User deleted");



 //       connection.close();

    }

}
