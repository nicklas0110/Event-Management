package DAL;

import BE.Customer;
import BE.EventCoordinator;
import DAL.db.DatabaseConnector;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    private DatabaseConnector DC;

    public CustomerDAO() throws IOException {
        DC = new DatabaseConnector();
    }

    public Customer addCustomer(String name, String lastName, String phoneNumber, String email, Boolean uploadOver12År) throws SQLException {
        // This is the method to create a EventCoordinator in the Database. This is also where the EventCoordinator gets an ID.


        Connection con = DC.getConnection();


        String sql = "INSERT INTO CustomerTable (NameCustomer,LastNameCustomer,PhoneNumberCustomer, EmailCustomer,is_checked) VALUES (?,?,?,?,?,?);";

        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        ps.setString(1, name);
        ps.setString(2, lastName);
        ps.setInt(3, Integer.parseInt(phoneNumber));
        ps.setString(4, email);
        ps.setBoolean(5,uploadOver12År);
        ps.setString(6,"Customer");

        int affectedRows = ps.executeUpdate();
        if (affectedRows == 1) {
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                return new Customer(id, name, lastName, phoneNumber, email,uploadOver12År);
            }

        }
        return null;
    }

    public Customer getAllCustomers() throws SQLException {
        Connection con = DC.getConnection();

        List<Customer> allCustomer = new ArrayList<>();


        String sql = "SELECT * FROM CustomerTable WHERE Customer = 'Customer'";
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) { // Creates and adds song objects into an array list
            Customer customer = new Customer(rs.getInt("id"), rs.getString("name"),
                    rs.getString("lastName"),rs.getString("phoneNumber"),rs.getString("email"),
                    rs.getBoolean("over12YearsOld"));
            allCustomer.add(customer);
        }
        return (Customer) allCustomer;
    }

    public void removeCustomer(Customer selectedCustomer) {
        String sql1 = "DELETE FROM CustomerTable WHERE ID = (?);";

        try (Connection connection = DC.getConnection()) {
            PreparedStatement ps1 = connection.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);

            ps1.setInt(1, selectedCustomer.getId());

            ps1.executeUpdate();

        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
