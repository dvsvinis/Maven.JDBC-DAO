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
//        User user = new User(12, "Walt","Disney", "wdisney@disney.com", "Orland", "FL", "12345");
//        run.create(user);
//        System.out.println("User created");
//        run.connection.close();

//        //Test findById
        System.out.println(run.findById(3).toString());

//        //Test findAll()
//         List<User> allUsers = run.findAll();
//        for (User i : allUsers) {
//            System.out.println(i.toString());
//        }

//        //Test update()
//        User user3 = run.findById(3);
//        user3.setCity("Dallas");
//        User updatedUser = run.update(user3);
//        System.out.println("User updated");

//        //Test delete()
//        run.delete(12);
//        System.out.println("User deleted");
//
//        run.connection.close();

    }

}
