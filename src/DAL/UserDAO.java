package DAL;

import BE.User;
import BE.UserType;
import DAL.db.DatabaseConnector;

import java.io.IOException;
import java.sql.*;

public class UserDAO {

    private DatabaseConnector DC;

    public UserDAO() throws IOException
    {
        DC = new DatabaseConnector();
    }

    public User GetUserByUsername(String username, String password) {
        try (Connection connection = DC.getConnection()) {
            String sqlStatement = "SELECT * FROM UserTable WHERE UserName = ? AND UserPassword = ?";
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            statement.setString(1, username);
            statement.setString(2, password);
            if (statement.execute()) {
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    String usr = resultSet.getString("UserName");
                    UserType userType = UserTypeStrToEnum(resultSet.getString("UserType"));

                    return new User(usr, userType);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    private UserType UserTypeStrToEnum(String str) {
        return switch (str) {
            case "Admin" -> UserType.Admin;
            case "EventCoordinator" -> UserType.EventCoordinator;
            case "BE.Customer" -> UserType.Customer;
            default -> UserType.Customer;
        };
    }

}
