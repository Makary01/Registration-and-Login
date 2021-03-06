package dao;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import model.User;
import org.mindrot.jbcrypt.BCrypt;
import utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    //SQL QUERIES
    private static final String CREATE_USER_QUERY = "INSERT INTO user(name,email,password,is_admin) VALUES (?,?,?,?);";
    private static final String VERIFY_USER_QUERY  = "SELECT * FROM user WHERE name = ? OR email = ?;";


    //Create User in database, returns user with id
    public User createUser(User user){
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement insertUser = connection.prepareStatement
                     (CREATE_USER_QUERY, PreparedStatement.RETURN_GENERATED_KEYS)){
            insertUser.setString(1, user.getName() );
            insertUser.setString(2, user.getEmail());
            insertUser.setString(3, user.getPassword());
            insertUser.setInt(4, user.getIsAdmin() ? 1 : 0);
            try{
                insertUser.executeUpdate();
            }catch (MySQLIntegrityConstraintViolationException e){
                return null;
            }
            try (ResultSet generatedKeys = insertUser.getGeneratedKeys()) {
                if (generatedKeys.first()) {
                    user.setId(generatedKeys.getInt(1));
                    return user;
                } else {
                    throw new RuntimeException("Generated key was not found");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    //Verifies the user, returns user if data is correct, null when incorrect
    public User verifyUser(String nameOrEmail, String password){
        try(Connection conn = DbUtil.getConnection();
        PreparedStatement verifyUserPrepStm = conn.prepareStatement(VERIFY_USER_QUERY)){
            verifyUserPrepStm.setString(1, nameOrEmail);
            verifyUserPrepStm.setString(2, nameOrEmail);
            ResultSet resultSet = verifyUserPrepStm.executeQuery();
            if(resultSet.next()){
                User userToReturn = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getInt("is_admin")==1
                );
                if(BCrypt.checkpw(password,userToReturn.getPassword())){
                    return userToReturn;
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

}
