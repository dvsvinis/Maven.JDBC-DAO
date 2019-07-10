package daos;

import models.DbUtil;
import models.User;

import javax.sound.midi.Instrument;
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
        private static final String UPDATE = "UPDATE user SET firstName = ?, lastName = ?, email = ?, " +
                "city = ?, state = ?, zipcode = ? WHERE id = ?";
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
                user.setId(rs.getInt("id"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmail(rs.getString("email"));
                user.setCity(rs.getString("city"));
                user.setState(rs.getString("state"));
                user.setZipcode(rs.getString("zipcode"));
            }
        } catch (SQLException e){
            DbUtil.showErrorMessage(e);
        }
        return user;
    }

    public List<User> findAll() {
        List<User> listOfUsers = new ArrayList<>();
        try(PreparedStatement pstmt = DbUtil.getConnection().prepareStatement(GET_ALL)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmail(rs.getString("email"));
                user.setCity(rs.getString("City"));
                user.setState(rs.getString("State"));
                user.setZipcode(rs.getString("Zipcode"));
                listOfUsers.add(user);
            }

        } catch (SQLException e) {
            DbUtil.showErrorMessage(e);
        }
         return listOfUsers;
    }

    public User create(User dto) {
        int key = -1;
        try(PreparedStatement pstmt = this.connection.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS)){
            pstmt.setInt(1, dto.getId());
            pstmt.setString(2, dto.getFirstName());
            pstmt.setString(3, dto.getLastName());
            pstmt.setString(4, dto.getEmail());
            pstmt.setString(5, dto.getCity());
            pstmt.setString(6, dto.getState());
            pstmt.setString(7, dto.getZipcode());
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();

            if (rs != null && rs.next()) {
                key = rs.getInt(1);
            }
        }catch(SQLException e){
            DbUtil.showErrorMessage(e);
        }
        return this.findById(key);
    }

    public User update(User dto) {
        User user = null;
        try(PreparedStatement pstmt = this.connection.prepareStatement(UPDATE)){
            pstmt.setInt(7, dto.getId());
            pstmt.setString(1, dto.getFirstName());
            pstmt.setString(2, dto.getLastName());
            pstmt.setString(3, dto.getEmail());
            pstmt.setString(4, dto.getCity());
            pstmt.setString(5, dto.getState());
            pstmt.setString(6, dto.getZipcode());
            pstmt.executeUpdate();
            user = this.findById(dto.getId());
        }catch (SQLException e){
            DbUtil.showErrorMessage(e);
        }
            return user;
    }

    public void delete(int id) {
        try (PreparedStatement pstmt = this.connection.prepareStatement(DELETE)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            DbUtil.showErrorMessage(e);
        }
    }

}