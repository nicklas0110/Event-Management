package GUI.controller;

import BE.Admin;
import BE.Customer;
import BE.EventCoordinator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


import java.io.IOException;


public class MainLoginController {
    @FXML
    private TextField UserNameField;

    @FXML
    private PasswordField PasswordField;

    @FXML
    private Button btnLogin;


    private Admin admin = new Admin();
    //private Customer customer = new Customer();
    private EventCoordinator eventCoordinator = new EventCoordinator();

    public void LogInAction() throws IOException {

        if (PasswordField.getText().equals(admin.getAdminPassword()) && UserNameField.getText().equals(admin.getAdminUserName())) {
            Stage stage = (Stage) btnLogin.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Admin.fxml"));
            stage.setTitle("AdminView");
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } else if (PasswordField.getText().equals(eventCoordinator.getEventPassword()) && UserNameField.getText().equals(eventCoordinator.getEventUserName())) {
            Stage switcher = (Stage) btnLogin.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/EventCoordinator.fxml"));
            Scene scene = new Scene(root);
            switcher.setTitle("EventCoordinatorManagement");
            switcher.setScene(scene);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Check your user name or password");
            alert.showAndWait();
        }
    }

    StackPane pane = new StackPane();

    public void saveLogin(ActionEvent actionEvent) {
    }
}
