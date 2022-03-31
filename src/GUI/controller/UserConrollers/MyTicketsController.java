package GUI.controller.UserConrollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MyTicketsController {
    @FXML
    private Button eventExample;
    @FXML
    private Button back;

    public void eventExampleButton(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) eventExample.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Billet.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("EventCoordinatorManagement");
        switcher.setScene(scene);

    }

    public void backBtn(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) back.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/CustomerViews/Customer.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("EventCoordinatorManagement");
        switcher.setScene(scene);
    }
}
