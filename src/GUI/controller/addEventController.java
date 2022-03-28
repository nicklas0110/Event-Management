package GUI.controller;

import GUI.Model.EventModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

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

    private EventModel eventModel;

    public addEventController() throws IOException {
        this.eventModel = new EventModel();
    }

    public void onActionSaveEvent() throws Exception {
        String eventName = txtFieldEventName.getText();
        String eventDate = txtFieldEventDate.getText();
        String eventTime = txtFieldEventTime.getText();
        String eventLocation = txtFieldEventLocation.getText();

        uploadEventInfo(eventName,eventDate,eventTime,eventLocation);

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


    public void uploadEventInfo(String String Event, String start, String Location) throws Exception {
        EventModel eventModelInfo = new EventModel();

        eventModelInfo.addEvent(Event, start, Location);
    }




}