package GUI.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminController {
    public TableView adminEventMangerTableView;
    public TableColumn adminEventMangerTableViewName;
    public TableColumn adminEventMangerTableViewLastname;
    public TableColumn adminEventMangerTableViewEmail;
    public TableColumn adminEventMangerTableViewEvents;
    public JFXButton createEventManger;
    public JFXButton editEventManger;
    public JFXButton deletEventManger;
    public JFXButton logOutAdmin;



    public void createEventMangerBtn(ActionEvent event) throws IOException {
        Stage stage = (Stage) createEventManger.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/newEventManger.fxml"));
        stage.setTitle("Customer");
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    public void editEventMangerBtn(ActionEvent event) {
    }

    public void deletEventMangerBtn(ActionEvent event) {
    }

    public void logOutAdminBtn(ActionEvent event) {
    }
}
