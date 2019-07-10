package daos;

import models.DbUtil;
import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDao extends Dao<User>{

        private static final String INSERT = "Insert into user" +
                "(id, firstName, lastName, email, city, state, zipcode)" +
                "values(?,?,?,?,?,?,?)";
        private static final String GET_ONE = "SELECT * FROM user WHERE id = ?";
        private static final String GET_ALL = "SELECT * FROM user";
        private static final String UPDATE = "UPDATE user SET user = ?, firstName = ?, lastName = ?, email = ?, " +
                "city = ?, state = ? WHERE id = ?";
        private static final String DELETE = "DELETE FROM user WHERE id = ?";


    public UserDao(Connection connection){
            super(connection);
        }

    public User findById(int id) {
        User user = null;
        try(PreparedStatement pstmt = DbUtil.getConnection().prepareStatement(GET_ONE)){
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                user = new User();
                user.setId(rs.getInt("Id"));
                user.firstName(rs.getString("firstName"));
                user.lastName(rs.getString("lastName"));
                user.email(rs.getString("email"));
                user.city(rs.getString("city"));
                user.state(rs.getString("state"));
                user.zipcode(rs.getString("zipcode"));
            }
        } catch (SQLException e){
            DbUtil.showErrorMessage(e);
        }
        return user;
    }

    public List<User> findAll() {
        List<User> listOfUsers = new ArrayList<>();
         return listOfUsers;
    }

    public User create(User dto) {
        return null;
    }

    public User update(User dto) {
        User user = null;
        return user;
    }

    public void delete(int id) {
    }



}