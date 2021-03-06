package GUI.controller;

import BLL.LoginManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MainLoginController{
    @FXML
    private TextField UserNameField;

    @FXML
    private PasswordField PasswordField;

    @FXML
    private Button btnLogin;
    //private BE.Customer customer = new BE.Customer();


    private LoginManager loginManager;

    public MainLoginController() {
        try {
            loginManager = LoginManager.getLoginManager();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Could not connect to database");
            alert.showAndWait();
        }
    }

    public void LogInAction() throws IOException {
        if (loginManager.login(UserNameField.getText(), PasswordField.getText())) {
            switch (loginManager.getLoggedInUser().getUserType()) {
                case Admin -> loadAdminView();
                case EventCoordinator -> loadEventCoordinatorView();
                case Customer -> loadCustomerView();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Check your user name or password");
            alert.showAndWait();
        }
    }

    private void loadCustomerView() throws IOException {
        Stage stage = (Stage) btnLogin.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/CustomerViews/Customer.fxml"));
        stage.setTitle("BE.Customer");
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    private void loadEventCoordinatorView() throws IOException {
        Stage switcher = (Stage) btnLogin.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/EventCoordinatorViews/EventCoordinator.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("EventCoordinatorManagement");
        switcher.setScene(scene);
    }

    private void loadAdminView() throws IOException {
        Stage stage = (Stage) btnLogin.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/AdminView/Admin.fxml"));
        stage.setTitle("AdminView");
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    StackPane pane = new StackPane();

    public void saveLogin(ActionEvent actionEvent) {
    }

    public void handleOnKeyPressed(KeyEvent keyEvent) throws IOException {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            LogInAction();
        }
    }
}
