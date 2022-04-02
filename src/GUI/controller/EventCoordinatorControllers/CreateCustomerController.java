package GUI.controller.EventCoordinatorControllers;

import BE.Customer;
import GUI.Model.CustomerModel;
import GUI.Model.EventCoordinatorModel;
import GUI.controller.SimpleDialogController;
import com.jfoenix.controls.JFXButton;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CreateCustomerController implements Initializable {
    public CustomerModel customerModel;
    public Customer selectedCustomer;


    public TableView<Customer> tvCustomers;
    public TableColumn<Customer, String> tcCustomerID;
    public TableColumn<Customer, String> tcFirstName;
    public TableColumn<Customer, String> tcLastName;
    public TableColumn<Customer, String> tcPhoneNumber;
    public TableColumn<Customer, String> tcEmail;

    public TextField customerNameTxt;
    public TextField customerLastNameTxt;
    public TextField customerPhoneNumberTxt;
    public TextField customerEmailTxt;

    public JFXButton addCustomer;
    public JFXButton btnBack;
    public JFXButton deleteCustomer;
    public JFXButton editCustomer;
    public CheckBox checkBoxOver12År;

    public CreateCustomerController() {
        customerModel = new CustomerModel();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            setCustomersView();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void addCustomerBtn(ActionEvent event) throws SQLException {
        String uploadName = customerNameTxt.getText().replaceAll(" ", "");
        String uploadLastName = customerLastNameTxt.getText().replaceAll(" ", "");
        String uploadPhoneNumber = customerPhoneNumberTxt.getText().replaceAll(" ", "");
        uploadPhoneNumber = uploadPhoneNumber.replaceAll(" ", "");
        uploadPhoneNumber = uploadPhoneNumber.replaceAll("\\+", "");
        uploadPhoneNumber = uploadPhoneNumber.replaceAll("-", "");
        String uploadEmail = customerEmailTxt.getText().replaceAll(" ", "");
        boolean uploadOver12År = checkBoxOver12År.isSelected();
        uploadCustomerInfo(uploadName, uploadLastName, uploadPhoneNumber, uploadEmail, uploadOver12År);
    }

    private void uploadCustomerInfo(String name, String lastName, String phoneNumber, String email, boolean uploadOver12År) throws SQLException {
        customerModel.addCustomer(name, lastName, phoneNumber, email, uploadOver12År);
        customerNameTxt.clear();
        customerLastNameTxt.clear();
        customerPhoneNumberTxt.clear();
        customerEmailTxt.clear();
        checkBoxOver12År.setSelected(false);
        tvCustomers.refresh();
    }

    public void handleBtnBack(ActionEvent event) throws IOException {
        backEventCoordinator(event);
    }

    public void deleteCustomerBtn(ActionEvent event) {
        if (SimpleDialogController.delete() && selectedCustomer != null) {
            customerModel.removeCustomer(selectedCustomer);
        }
    }

    public void EditCustomerBtn(ActionEvent event) {
    }

    private void backEventCoordinator(ActionEvent event) throws IOException {
        Stage switcher = (Stage) btnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/EventCoordinatorViews/EventCoordinator.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("EventCoordinatorManagement");
        switcher.setScene(scene);
    }

    /**
     * m
     * Method used for initializing the Customers table.
     */
    private void setCustomersView() throws IOException {

        tcCustomerID.setCellValueFactory(new PropertyValueFactory<>("id"));

        tcFirstName.setCellValueFactory(new PropertyValueFactory<>("Name"));

        tcLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        tcPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        tcEmail.setCellValueFactory(new PropertyValueFactory<>("email"));


        tvCustomers.setItems(customerModel.getCustomers());
    }


}
