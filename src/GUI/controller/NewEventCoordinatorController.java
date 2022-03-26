package GUI.controller;

import GUI.Model.EventCoordinatorModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class NewEventCoordinatorController {
    public JFXTextArea lastNameInput;
    public JFXTextArea emailInput;
    public JFXTextArea passwordInput;
    public JFXTextArea nameInput;
    public JFXTextArea userNameInput;
    public JFXButton newEventCoordinatorCancel;



    /**
     * her uploades vores data til vores model layer, dataen får den fra LogicManger.
     *
     * @param userName
     * @param password
     * @param name
     * @throws IOException
     * @throws SQLException
     */
    public void uploadEventCoordinatorInfo(String userName, String password, String name) throws Exception {
        EventCoordinatorModel privateMovieCollectionModel = new EventCoordinatorModel();

        privateMovieCollectionModel.addEventCoordinator(userName, password, name);
    }

    public void createEventCoordinatorBtn(ActionEvent actionEvent) throws Exception {
        String uploadUserName = userNameInput.getText().replaceAll(" ","");
        String uploadpassword = passwordInput.getText().replaceAll(" ","");
        String uploadName = nameInput.getText().replaceAll(" ","");
        uploadEventCoordinatorInfo(uploadUserName, uploadpassword, uploadName);

        Stage stage = (Stage) newEventCoordinatorCancel.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Admin.fxml"));
        stage.setTitle("AdminView");
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    public void newEventCoordinatorCancelBtn(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) newEventCoordinatorCancel.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Admin.fxml"));
        stage.setTitle("AdminView");
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

}
