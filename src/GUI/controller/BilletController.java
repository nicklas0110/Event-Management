package GUI.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class BilletController {
    @FXML
    public JFXButton btnTicketBack;


    public void backToCustomerView(ActionEvent event) throws IOException {
        Stage switcher = (Stage) btnTicketBack.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/CustomerViews/Customer.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("EventCoordinatorManagement");
        switcher.setScene(scene);
    }
}
