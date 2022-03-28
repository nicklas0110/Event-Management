package GUI.controller;

import GUI.Model.EventModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class addEventController {
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
    public Button btnBack;
    public TextArea txtFieldEventInfo;

    private EventModel eventModel;

    public addEventController() throws IOException {
        this.eventModel = new EventModel();
    }

    public void onActionSaveEvent() throws Exception {
        String eventName = txtFieldEventName.getText();
        String eventDate = txtFieldEventDate.getText();
        String eventTime = (txtFieldEventTime.getText());
        String eventLocation = txtFieldEventLocation.getText();
        String eventInfoText = txtFieldEventInfo.getText();

        uploadEventInfo(eventName,eventDate,eventTime,eventLocation,eventInfoText);

        /*
        eventModel.createEvent(eventName, eventDate, eventTime, eventLocation);
        Stage stage = (Stage) btnCreateEvent.getScene().getWindow();
        stage.close();
    }

    public void handleBtnBack(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.close();
    }

         */
    }


    public void uploadEventInfo(String event, String start, String eventTime, String location, String eventInfo) throws Exception {
        EventModel eventModelInfo = new EventModel();

        eventModelInfo.addEvent(event, start, eventTime ,location,eventInfo);
    }

    public void handleBtnBack(ActionEvent actionEvent) {
    }
}