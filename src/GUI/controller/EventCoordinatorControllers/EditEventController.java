package GUI.controller.EventCoordinatorControllers;

import BE.Event;
import GUI.Model.EventModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
        this.selectedEvent = event;
    }

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

        eventModel.updateEvents(this.selectedEvent);

        /*
        Stage stage = (Stage) btnEditEvent.getScene().getWindow();
        stage.close();

         */


    }



    @FXML
    public void handleBtnBack() {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.close();
    }
}
