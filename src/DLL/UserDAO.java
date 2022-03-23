package DLL;

import BE.User;
import BE.UserType;
import DLL.db.DatabaseConnector;

import java.io.IOException;
import java.sql.*;

public class UserDAO {

    private DatabaseConnector DC;

    public UserDAO() throws IOException
    {
        DC = new DatabaseConnector();
    }

    public User GetUserByUsername(String username) {
        try (Connection connection = DC.getConnection()) {
            String sqlStatement = "SELECT * FROM UserTable WHERE UserName = ?";
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            statement.setString(1, username);

            if (statement.execute()) {
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    String usr = resultSet.getString("UserName");
                    String password = resultSet.getString("UserPassword");
                    UserType userType = UserTypeStrToEnum(resultSet.getString("UserType"));

                    return new User(usr, password, userType);
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
            case "Customer" -> UserType.Customer;
            default -> UserType.Customer;
        };
    }

}
