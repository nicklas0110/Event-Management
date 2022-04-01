package GUI.controller.EventCoordinatorControllers;

import BE.Event;
import GUI.Model.EventModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class EditEventController {

    @FXML
    public TextField txtFieldEventName;
    @FXML
    public TextField txtFieldEventDate;
    @FXML
    public TextField txtFieldEventTime;
    @FXML
    public TextField txtFieldEventLocation;
    @FXML
    public TextArea txtFieldEventInfo;

    @FXML
    public Button btnEditEventCoordinator;
    @FXML
    public Button btnEditEvent;
    @FXML
    public Button btnBack;


    private Event selectedEvent;
    private EventModel eventModel = new EventModel();

    public EditEventController() throws IOException {
    }


    public void setSelectedEvent(Event event) throws Exception {
        txtFieldEventName.setText(event.getEventName());
        txtFieldEventDate.setText(event.getEventDate());
        txtFieldEventTime.setText(event.getEventTime());
        txtFieldEventLocation.setText(event.getEventLocation());
        txtFieldEventInfo.setText(event.getEventInfo());
        this.selectedEvent = event;
    }

    @FXML
    public void onActionSaveEvent(ActionEvent actionEvent) throws Exception {
        String updateEventName = txtFieldEventName.getText();
        String updateEventDate = txtFieldEventDate.getText();
        String updateEventTime = txtFieldEventTime.getText();
        String updateEventLocation = txtFieldEventLocation.getText();
        String updateEventInfo = txtFieldEventInfo.getText();

        this.selectedEvent.setEventName(updateEventName);
        this.selectedEvent.setEventDate(updateEventDate);
        this.selectedEvent.setEventTime(updateEventTime);
        this.selectedEvent.setEventLocation(updateEventLocation);
        this.selectedEvent.setEventInfo(updateEventInfo);

        eventModel.editEvents(this.selectedEvent);

        backToEventcoordinatorWindow(actionEvent);

    }



    @FXML
    public void handleBtnBack(ActionEvent actionEvent) throws IOException {
        backToEventcoordinatorWindow(actionEvent);
    }

    private void backToEventcoordinatorWindow(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) btnEditEventCoordinator.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/EventCordinatorViews/EventCoordinator.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("EventCoordinatorManagement");
        switcher.setScene(scene);
    }

}
