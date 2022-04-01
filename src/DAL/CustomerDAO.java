package DAL;

import BE.Customer;
import BE.EventCoordinator;
import DAL.db.DatabaseConnector;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.*;

public class CustomerDAO {

    private DatabaseConnector DC;

    public CustomerDAO() throws IOException {
        DC = new DatabaseConnector();
    }

    public Customer addCustomer(String name, String lastName, String phoneNumber, String email) throws SQLException {
        // This is the method to create a EventCoordinator in the Database. This is also where the EventCoordinator gets an ID.


        Connection con = DC.getConnection();


        String sql = "INSERT INTO UserTable (UserName,UserPassword,UserType, name) VALUES (?,?,?,?);";

        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        ps.setString(1, name);
        ps.setString(2, lastName);
        ps.setInt(3, Integer.parseInt(phoneNumber));
        ps.setString(4, email);

        int affectedRows = ps.executeUpdate();
        if (affectedRows == 1) {
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                Customer customer = new Customer(id, name, lastName, phoneNumber, email);
                return customer;
            }

        }
        return null;
    }

}
