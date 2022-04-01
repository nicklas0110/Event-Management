package GUI.Model;

import BE.Customer;
import BLL.CustomerManager;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class CustomerModel {
    private ObservableList<Customer> customerList = FXCollections.observableArrayList();

    private CustomerManager customerManagerLm;

    public void addCustomer(String name, String lastName, String phoneNumber, String email) throws SQLException {
        customerList.add(customerManagerLm.addCustomer(name, lastName, phoneNumber, email));
    }

    public ObservableList<Customer> getCustomers() {
        customerList = customerManagerLm.getCustomers();
        return customerList;
    }
}
