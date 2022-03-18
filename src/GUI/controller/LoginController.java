package GUI.controller;

import BE.Admin;
import BE.Customer;
import BE.EventCoordinator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


import java.awt.*;
import java.io.IOException;


public class LoginController {
    @FXML
    private TextField UserNameField;

    @FXML
    private PasswordField PasswordField;

    @FXML
    private Button btnLogin;


    private Admin admin = new Admin();
    private Customer customer = new Customer();
    private EventCoordinator eventCoordinator = new EventCoordinator();

    public void LogInAction() throws IOException {

        if (PasswordField.getText().equals(admin.getPassword()) && UserNameField.getText().equals(admin.getUserName())) {
            Stage stage = (Stage) btnLogin.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Admin.fxml"));
            stage.setTitle("AdminView");
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } else if (PasswordField.getText().equals(customer.getPassword()) && UserNameField.getText().equals(customer.getUserName())) {
            Stage switcher = (Stage) btnLogin.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Customer.fxml"));
            Scene scene = new Scene(root);
            switcher.setTitle("CustomerManagement");
            switcher.setScene(scene);
        }
        else if  (PasswordField.getText().equals(eventCoordinator.getPassword()) && UserNameField.getText().equals(eventCoordinator.getUserName())) {
            Stage switcher = (Stage) btnLogin.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/EventCoordinator.fxml"));
            Scene scene = new Scene(root);
            switcher.setTitle("EventCoordinatorManagement");
            switcher.setScene(scene);
        }

    }
   StackPane pane = new StackPane();

    public void saveLogin(ActionEvent actionEvent) {
    }
}
