package GUI.controller;

import BE.EventCoordinator;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;

public class EditEventCoordinatorController {

    public JFXTextArea lastNameInputEdit;
    public JFXTextArea emailInputEdit;
    public JFXTextArea nameInputEdit;
    public JFXTextArea userNameInputEdit;

    /**
     * sets the values of the selected eventCoordinator.
     */
    public void setSelectedEventCoordinator(EventCoordinator eventCoordinator) {
        nameInputEdit.setText(eventCoordinator.getName());
        lastNameInputEdit.setText(String.valueOf(eventCoordinator.getLastName()));
        userNameInputEdit.setText(String.valueOf(eventCoordinator.getUsername()));
    }

    public void EditEventCoordinatorBtn(ActionEvent actionEvent) {
    }

    public void editEventCoordinatorCancelBtn(ActionEvent actionEvent) {
    }
}
