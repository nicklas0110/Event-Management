package GUI.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class EventCoordinatorController {

    @FXML
    private Button btnAddEventkoordinator;

    @FXML
    private Button btnEditEventKoordinator;

    @FXML
    private Button btnLogOuteventCoordinator;



    public void ButtonLogOutFromEventCoordinator(ActionEvent actionEvent) throws IOException {

        Stage switcher = (Stage) btnLogOuteventCoordinator.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/MainLoginView.fxml"));
        Scene scene = new Scene(root);
        switcher.setScene(scene);
    }

    public void addEventActionButton(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) btnAddEventkoordinator.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/addEvent.fxml"));
        switcher.setTitle("Add New Event");
        Scene scene = new Scene(root);
        switcher.setScene(scene);
    }

    public void EditEventActionButton(ActionEvent actionEvent) throws IOException {

        Stage switcher = (Stage) btnEditEventKoordinator.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/editEvent.fxml"));
        switcher.setTitle("Create New Event");
        Scene scene = new Scene(root);
        switcher.setScene(scene);
    }
}
