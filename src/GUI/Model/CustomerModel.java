package GUI.Model;

import BE.Customer;
import BLL.CustomerManager;
import BLL.EventCoordinatorCoordinator;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.SQLException;

public class CustomerModel {
    private ObservableList<Customer> customerList = FXCollections.observableArrayList();

    private CustomerManager customerManagerLm;

    public CustomerModel() {
        try {
            customerManagerLm = new CustomerManager();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addCustomer(String name, String lastName, String phoneNumber, String email, Boolean uploadOver12År) throws SQLException {
        customerList.add(customerManagerLm.addCustomer(name, lastName, phoneNumber, email,uploadOver12År));
    }

    public ObservableList<Customer> getCustomers() {
        customerList = customerManagerLm.getCustomers();
        return customerList;
    }

    public void removeCustomer(Customer selectedCustomer) {
        customerManagerLm.removeCustomer(selectedCustomer);
        customerList.remove(selectedCustomer);
    }

    public ObservableList getAgeOver12() {
        customerList = customerManagerLm.getAgeOver12();
        return customerList;
    }

    public int getAgeUnderOrOver12(Boolean isOver) {
        int count = 0;
        for(Customer customer : customerList){
            if(customer.getOver12YearsOld() == isOver){
                count++;
            }
        }
        return count;
    }
}
