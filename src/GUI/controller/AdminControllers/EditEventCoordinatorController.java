package GUI.controller.AdminControllers;

import BE.EventCoordinator;
import GUI.Model.EventCoordinatorModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EditEventCoordinatorController {
    @FXML
    public JFXButton editEventCoordinatorCancel;
    @FXML
    public JFXButton EditEventCoordinator;

    @FXML
    public JFXTextArea lastNameInputEdit;
    @FXML
    public JFXTextArea emailInputEdit;
    @FXML
    public JFXTextArea nameInputEdit;
    @FXML
    public JFXTextArea userNameInputEdit;


    private EventCoordinator selectedEventCoordinator;
    private EventCoordinatorModel eventCoordinatorModel = new EventCoordinatorModel();

    public EditEventCoordinatorController() {
    }

    /**
     * sets the values of the selected eventCoordinator.
     */
    public void setSelectedEventCoordinator(EventCoordinator eventCoordinator) {
        userNameInputEdit.setText(eventCoordinator.getUsername());
        nameInputEdit.setText(eventCoordinator.getName());
        this.selectedEventCoordinator = eventCoordinator;
    }

    public void EditEventCoordinatorBtn(ActionEvent actionEvent) throws IOException {
        String updateEventCoordinatorUserName = userNameInputEdit.getText();
        String updateEventCoordinatorName = nameInputEdit.getText();
        this.selectedEventCoordinator.setUsername(updateEventCoordinatorUserName);
        this.selectedEventCoordinator.setName(updateEventCoordinatorName);

        eventCoordinatorModel.updateEventCoordinator(this.selectedEventCoordinator);

        cancel(actionEvent);

    }

    private void cancel(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) editEventCoordinatorCancel.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/AdminView/Admin.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("EventCoordinatorManagement");
        switcher.setScene(scene);
    }

    public void editEventCoordinatorCancelBtn(ActionEvent actionEvent) throws IOException {
        cancel(actionEvent);
    }
}
