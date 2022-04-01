package BLL;

import BE.Customer;
import DAL.CustomerDAO;
import DAL.EventCoordinatorDAO;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.SQLException;

public class CustomerManager {
    CustomerDAO customerDAO = new CustomerDAO();

    public CustomerManager() throws IOException {
    }

    public Customer addCustomer(String name, String lastName, String phoneNumber, String email) throws SQLException {
        return (customerDAO.addCustomer(name, lastName, phoneNumber,email));
    }
}
