package GUI.controller.EventCoordinatorControllers;

import GUI.Model.CustomerModel;
import GUI.Model.EventCoordinatorModel;
import com.jfoenix.controls.JFXButton;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CreateCustomerController implements Initializable {
    public TableView tvCustomers;
    public TableColumn tcCustomerID;
    public TableColumn tcFirstName;
    public TableColumn tcLastName;
    public TableColumn tcPhoneNumber;
    public TableColumn tcEmail;

    public TextField customerNameTxt;
    public TextField customerLastNameTxt;
    public TextField customerPhoneNumberTxt;
    public TextField customerEmailTxt;

    public JFXButton addCustomer;
    public JFXButton btnBack;
    public JFXButton deleteCustomer;
    public JFXButton editCustomer;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void addCustomerBtn(ActionEvent event) throws SQLException {
        String uploadName = customerNameTxt.getText().replaceAll(" ", "");
        String uploadLastName = customerLastNameTxt.getText().replaceAll(" ", "");
        String uploadPhoneNumber = customerPhoneNumberTxt.getText().replaceAll(" ", "");
        String uploadEmail = customerEmailTxt.getText().replaceAll(" ", "");
        uploadCustomerInfo(uploadName, uploadLastName, uploadPhoneNumber, uploadEmail);
    }

    private void uploadCustomerInfo(String name, String lastName, String phoneNumber, String email) throws SQLException {
        CustomerModel customerModel = new CustomerModel();

        customerModel.addCustomer(name, lastName, phoneNumber, email);
    }

    public void handleBtnBack(ActionEvent event) throws IOException {
        backEventCoordinator(event);
    }

    public void deleteCustomerBtn(ActionEvent event) {
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


}
