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

    public Customer addCustomer(String name, String lastName, String phoneNumber, String email, Boolean uploadOver12År, int eventID) throws SQLException {
        // This is the method to create a EventCoordinator in the Database. This is also where the EventCoordinator gets an ID.

        try (Connection connection = DC.getConnection()) {
            String sql = "INSERT INTO CustomerTable (NameCustomer,LastNameCustomer,PhoneNumberCustomer, EmailCustomer,is_checked,Customer) VALUES (?,?,?,?,?,?);";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, name);
            ps.setString(2, lastName);
            ps.setInt(3, Integer.parseInt(phoneNumber));
            ps.setString(4, email);
            ps.setBoolean(5, uploadOver12År);
            ps.setString(6, "Customer");

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                //Add relation between Customer and Event
                setEventCustomer(id, eventID);
                return new Customer(id, name, lastName, phoneNumber, email, uploadOver12År);
            }
        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public List<Customer> getAllCustomers(int eventID) throws SQLException {
        List<Customer> allCustomer = new ArrayList<>();
        try (Connection connection = DC.getConnection()) {
            String select = "SELECT ct.CustomerID AS CustomerID, ct.NameCustomer, ct.LastNameCustomer, ct.PhoneNumberCustomer, ct.EmailCustomer, ct.is_checked";
            String from = " FROM CustomerTable AS ct INNER JOIN EventCustomer AS ec ON ct.CustomerID = ec.CustomerID ";
            String where = " WHERE Customer = 'Customer' AND ec.EventID = ?";
            String sql = select + from + where;
            Statement statement = connection.createStatement();
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, eventID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) { // Creates and adds song objects into an array list

                Customer customer = new Customer(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getBoolean(6));
                allCustomer.add(customer);
            }

        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return allCustomer;
    }

    public void removeCustomer(Customer selectedCustomer) {
        String sql1 = "DELETE FROM EventCustomer WHERE CustomerID = (?);";
        String sql2 = "DELETE FROM CustomerTable WHERE CustomerID = (?);";

        try (Connection connection = DC.getConnection()) {
            PreparedStatement ps1 = connection.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement ps2 = connection.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);

            ps1.setInt(1, selectedCustomer.getId());
            ps2.setInt(1, selectedCustomer.getId());

            ps1.executeUpdate();
            ps2.executeUpdate();


        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Customer getAgeOver12() {
        List<Customer> ageOver12 = new ArrayList<>();
        try (Connection connection = DC.getConnection()) {


            String sql = "SELECT * FROM CustomerTable WHERE is_checked = '1'";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) { // Creates and adds song objects into an array list
                Customer customer = new Customer(rs.getInt("CustomerID"), rs.getString("NameCustomer"),
                        rs.getString("LastNameCustomer"), rs.getString("PhoneNumberCustomer"), rs.getString("EmailCustomer"),
                        rs.getBoolean("is_checked"));
                ageOver12.add(customer);
            }

        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return (Customer) ageOver12;
    }

    public Customer getAgeUnder12() {
        List<Customer> ageUnder12 = new ArrayList<>();
        try (Connection connection = DC.getConnection()) {


            String sql = "SELECT * FROM CustomerTable WHERE is_checked = '0'";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) { // Creates and adds song objects into an array list
                Customer customer = new Customer(rs.getInt("CustomerID"), rs.getString("NameCustomer"),
                        rs.getString("LastNameCustomer"), rs.getString("PhoneNumberCustomer"), rs.getString("EmailCustomer"),
                        rs.getBoolean("is_checked"));
                ageUnder12.add(customer);
            }

        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return (Customer) ageUnder12;
    }

    public void setEventCustomer(int customerId, int eventId){
        try (Connection connection = DC.getConnection()) {
            String sql = "INSERT INTO EventCustomer(CustomerID, EventID) VALUES (?,?);";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, customerId);
            ps.setInt(2, eventId);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                //Add relation between Customer and Event
            }
        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
