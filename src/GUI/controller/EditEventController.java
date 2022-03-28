package GUI.controller;

import BE.Event;
import GUI.Model.EventModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    public Button btnCreateEvent;
    @FXML
    public Button btnEditEvent;
    @FXML
    public Button btnBack;
    @FXML
    public TextArea txtFieldEventInfo;

    @FXML
    public void onActionSaveEvent(ActionEvent actionEvent) {
    }

    @FXML
    public void handleBtnBack(ActionEvent actionEvent) {
    }

    EventModel eventModel;

    public void onActionSaveEvent() {
        String eventName = txtFieldEventName.getText();
        String eventDate = txtFieldEventDate.getText();
        String eventTime = txtFieldEventTime.getText();
        String eventLocation = txtFieldEventLocation.getText();
        String eventInfo = txtFieldEventInfo.getText();


        //Event event = new Event(eventName, eventDate, eventTime, eventLocation, eventInfo);
        //eventModel.editEvent(event);

        Stage stage = (Stage) btnEditEvent.getScene().getWindow();
        stage.close();
    }

    public void setSelectedEvent(Event event) {
        txtFieldEventName.setText(event.getEventName());
        txtFieldEventDate.setText(event.getEventDato());
        txtFieldEventTime.setText(event.getEventTime());
        txtFieldEventLocation.setText(event.getEventLocation());
     }

    public void handleBtnBack() {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.close();
    }
}
