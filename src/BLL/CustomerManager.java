package BLL;

import BE.Customer;
import BE.Event;
import DAL.CustomerDAO;
import DAL.EventCoordinatorDAO;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.SQLException;

public class CustomerManager {
    CustomerDAO customerDAO = new CustomerDAO();

    public CustomerManager() throws IOException {
    }

    public Customer addCustomer(String name, String lastName, String phoneNumber, String email, Boolean uploadOver12År) throws SQLException {
        return (customerDAO.addCustomer(name, lastName, phoneNumber,email,uploadOver12År));
    }

    public ObservableList<Customer> getCustomers() {
        ObservableList<Customer> customers = FXCollections.observableArrayList();

        try {
            customers.addAll(customerDAO.getAllCustomers());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }

    public void removeCustomer(Customer selectedCustomer) {
        customerDAO.removeCustomer(selectedCustomer);
    }

    public ObservableList<Customer> getAgeOver12() {
        ObservableList<Customer> customers = FXCollections.observableArrayList();

        try {
            customers.addAll(customerDAO.getAgeOver12());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }

    public ObservableList<Customer> getAgeUnder12() {
        ObservableList<Customer> customers = FXCollections.observableArrayList();

        try {
            customers.addAll(customerDAO.getAgeUnder12());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }
}
