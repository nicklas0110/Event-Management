package GUI.controller;

import BE.Event;
import GUI.Model.EventCoordinatorModel;
import GUI.Model.EventModel;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
 import java.util.ResourceBundle;

 //remember implements Initializable this class

public class EventCoordinatorController  {
    @FXML
    public TableView tvEvents;
    @FXML
    public TableColumn tcId;
    @FXML
    public TableColumn tcEventName;
    @FXML
    public TableColumn tcEventDate;
    @FXML
    public TableColumn tcEventTime;
    @FXML
    public TableColumn tcEventLocation;
    @FXML
    public TableColumn tcEventInfo;
    @FXML
    public JFXButton btnAddEvent;
    @FXML
    public JFXButton btnEditEvent;
    @FXML
    public JFXButton btnDeleteEvent;

    @FXML
    private Button onActionAddEvent;

    @FXML
    private Button btnEditEventKoordinator;

    @FXML
    private Button btnLogOuteventCoordinator;



    private EventCoordinatorModel eventCoordinatorModel;
    private EventModel eventModel;
    private Event selectedEvent;
    private EditEventController editEventController;


    public EventCoordinatorController() throws IOException {
        this.eventCoordinatorModel = new EventCoordinatorModel();
        this.eventModel = new EventModel();
        //this.selectedEvent = new Event();
        this.editEventController = new EditEventController();
    }



    private void tableViewLoadEvents(ObservableList<Event> allEvents) {
        tvEvents.setItems(getEventData());
    }

    private ObservableList<Event> getEventData() {
        return allEvents;
    }

    private ObservableList<Event> allEvents = FXCollections.observableArrayList();
    public void ButtonLogOutFromEventCoordinator(ActionEvent actionEvent) throws IOException {

        Stage switcher = (Stage) btnLogOuteventCoordinator.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/MainLoginView.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Main log in view");
        switcher.setScene(scene);
    }

    public void onActionAddEvent(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) btnAddEvent.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/addEvent.fxml"));
        switcher.setTitle("Add New Event");
        Scene scene = new Scene(root);
        switcher.setScene(scene);
    }

    public void EditEventActionButton(ActionEvent actionEvent) throws IOException {

        Stage switcher = (Stage) btnEditEventKoordinator.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/eddEvent.fxml"));
        switcher.setTitle("Create New Event");
        Scene scene = new Scene(root);
        switcher.setScene(scene);
    }


    public void onActionAddEvent() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/CreteEvent.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Create Event");
        stage.setScene(new Scene(root));
        stage.show();
        stage.setOnHiding(event ->
        {
            /*
            try {
                allEvents = FXCollections.observableList(eventModel.getEvents());
                tableViewLoadEvents(allEvents);
            } catch (Exception e) {
                e.printStackTrace();
            }

             */
        });
    }





    public void onActionEditEvent() throws IOException {
         if (selectedEvent != null) {
            Event selectedEvent = (Event) tvEvents.getSelectionModel().getSelectedItem();

            FXMLLoader parent = new FXMLLoader(getClass().getResource("/GUI/View/CreteEvent.fxml"));
            Scene mainWindowScene = null;
            try {
                mainWindowScene = new Scene(parent.load());
            } catch (IOException exception) {
                exception.printStackTrace();
            }
            Stage editEventStage;
            editEventStage = new Stage();
            editEventStage.setScene(mainWindowScene);
            EditEventController editEventController = parent.getController();
            editEventController.setSelectedEvent(selectedEvent);
            editEventStage.show();
            editEventStage.setOnHiding(event ->
            {
                /*
                try {
                    allEvents = FXCollections.observableList(eventModel.getEvents());
                    tableViewLoadEvents(allEvents);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                 */
            });
        }
    }

    private void selectedEvent() {
        this.tvEvents.getSelectionModel().selectedItemProperty().addListener(((observableValue, oldValue, newValue) -> {
            if ((Event) newValue != null) {
                this.selectedEvent = (Event) newValue;
            }
        }));
    }

/*
    @Override

    public void initialize(URL location, ResourceBundle resources) {
        selectedEvent();

        tcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcEventName.setCellValueFactory(new PropertyValueFactory<>("EventName"));
        tcEventDate.setCellValueFactory(new PropertyValueFactory<>("EventDate"));
        tcEventLocation.setCellValueFactory(new PropertyValueFactory<>("EventLocation"));
        tcEventTime.setCellValueFactory(new PropertyValueFactory<>("EventTime"));
        tcEventInfo.setCellValueFactory(new PropertyValueFactory<>("EventInfo"));

        try {
            allEvents = FXCollections.observableArrayList(eventModel.getEvents());
            tableViewLoadEvents(allEvents);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

 */


}
