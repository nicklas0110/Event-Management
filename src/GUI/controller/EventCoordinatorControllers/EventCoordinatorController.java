package GUI.controller.EventCoordinatorControllers;

import BE.Event;
import GUI.Model.CustomerModel;
import GUI.Model.EventCoordinatorModel;
import GUI.Model.EventModel;
import GUI.controller.SimpleDialogController;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
 import java.util.ResourceBundle;

 //remember implements Initializable this class

public class EventCoordinatorController  implements Initializable   {
    @FXML
    public TableView<Event> tvEvents;
    @FXML
    public TableColumn<Event, String> tcId;
    @FXML
    public TableColumn<Event, String> tcEventName;
    @FXML
    public TableColumn<Event, String> tcEventDate;
    @FXML
    public TableColumn<Event, String> tcEventTime;
    @FXML
    public TableColumn<Event, String> tcEventLocation;
    @FXML
    public TableColumn<Event, String> tcEventInfo;
    @FXML
    public JFXButton btnAddEvent;
    @FXML
    public JFXButton btnEditEvent;
    @FXML
    public JFXButton btnDeleteEvent;
    @FXML
    public JFXButton btnUserInfo;

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


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            setEventTableView();
        } catch (IOException e) {
            e.printStackTrace();
        }

        tvEvents.setOnMouseClicked((MouseEvent event) -> {
            setSelectedItems();
        });
    }


    public EventCoordinatorController() throws IOException {
        this.eventCoordinatorModel = new EventCoordinatorModel();
        this.eventModel = new EventModel();
        this.editEventController = new EditEventController();
    }


    public void ButtonLogOutFromEventCoordinator(ActionEvent actionEvent) throws IOException {

        Stage switcher = (Stage) btnLogOuteventCoordinator.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/MainLoginView.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Log in Event Management");
        switcher.setScene(scene);
    }

    public void onActionAddEvent(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) btnAddEvent.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/EventCoordinatorViews/addEvent.fxml"));
        switcher.setTitle("Add New Event");
        Scene scene = new Scene(root);
        switcher.setScene(scene);
    }


    public void onActionAddEvent() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/EventCoordinatorViews/editEvent.fxml"));
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

    /**m
     * Method used for initializing the EventCoordinator table.
     */
    private void setEventTableView() throws IOException {

        tcId.setCellValueFactory(new PropertyValueFactory<>("eventId"));

        tcEventName.setCellValueFactory(new PropertyValueFactory<>("eventName"));

        tcEventDate.setCellValueFactory(new PropertyValueFactory<>("eventDate"));

        tcEventTime.setCellValueFactory(new PropertyValueFactory<>("eventTime"));

        tcEventLocation.setCellValueFactory(new PropertyValueFactory<>("eventLocation"));

        tcEventInfo.setCellValueFactory(new PropertyValueFactory<>("eventInfo"));

        tvEvents.setItems(eventModel.getAllEvents());
    }



    public void onActionEditEvent(ActionEvent actionEvent) throws Exception {
         if (selectedEvent != null) {
            Event selectedEvent = (Event) tvEvents.getSelectionModel().getSelectedItem();

            FXMLLoader parent = new FXMLLoader(getClass().getResource("/GUI/View/EventCoordinatorViews/editEvent.fxml"));
            Scene mainWindowScene = null;
            try {
                mainWindowScene = new Scene(parent.load());
            } catch (IOException exception) {
                exception.printStackTrace();
            }
             Stage editEventCoordinatorStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
             editEventCoordinatorStage.setScene(mainWindowScene);
             EditEventController editEventController = parent.getController();
             editEventController.setSelectedEvent(selectedEvent);
             editEventCoordinatorStage.show();




            /*Stage editEventStage;
            editEventStage = new Stage();
            editEventStage.setScene(mainWindowScene);
            EditEventController editEventController = parent.getController();
            editEventController.setSelectedEvent(selectedEvent);
            editEventStage.show();
            editEventStage.setOnHiding(event ->
            {
            });

         */
        }


    }

    public void handleBtnDeleteEvent(ActionEvent event) {
        if (SimpleDialogController.delete() && selectedEvent != null) {
            eventModel.removeEvent(selectedEvent);
        }

    }

    /**
     * Changes selected Name  in the adminEventMangerTableViewName
     */
    private void setSelectedItems() {
        if (tvEvents.getSelectionModel().getSelectedItem() != null)
        {
            selectedEvent = tvEvents.getSelectionModel().getSelectedItem();
        }

    }


    public void UserInfoBtn(ActionEvent event) throws IOException {
        Stage switcher = (Stage) btnUserInfo.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/EventCoordinatorViews/CreateCustomer.fxml"));
        switcher.setTitle("Add New Event");
        Scene scene = new Scene(root);
        switcher.setScene(scene);
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
