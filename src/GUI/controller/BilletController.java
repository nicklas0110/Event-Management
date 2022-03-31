package GUI.controller;

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
    private Button close;


    public void closeBtn(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) close.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/CustomerViews/MyTickets.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("EventCoordinatorManagement");
        switcher.setScene(scene);
    }
}
