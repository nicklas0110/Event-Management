package GUI.controller;

import GUI.Model.EventMangerModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class NewEventMangerController {
    public JFXTextArea lastNameInput;
    public JFXTextArea emailInput;
    public JFXTextArea passwordInput;
    public JFXTextArea nameInput;
    public JFXTextArea userNameInput;
    public JFXButton newEventMangerCancel;

    /**
     * her uploades vores data til vores model layer, dataen får den fra LogicManger.
     *
     * @param userName
     * @param password
     * @param name
     * @throws IOException
     * @throws SQLException
     */
    public void uploadEventMangerInfo(String userName, String password, String name) throws Exception {
        EventMangerModel privateMovieCollectionModel = new EventMangerModel();

        privateMovieCollectionModel.addEventManger(userName, password, name);
    }

    public void createEventMangerBtn(ActionEvent actionEvent) throws Exception {
        String uploadUserName = userNameInput.getText();
        String uploadpassword = passwordInput.getText();
        String uploadName = nameInput.getText();
        uploadEventMangerInfo(uploadUserName, uploadpassword, uploadName);

        Stage stage = (Stage) newEventMangerCancel.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Admin.fxml"));
        stage.setTitle("Customer");
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    public void newEventMangerCancelBtn(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) newEventMangerCancel.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Admin.fxml"));
        stage.setTitle("Customer");
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }



}
