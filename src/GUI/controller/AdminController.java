package GUI.controller;

import BE.EventCoordinator;
import GUI.Model.EventMangerModel;
import com.jfoenix.controls.JFXButton;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {

    private final EventMangerModel eventMangerModel;

    public EventCoordinator selectedEventCoordinator;


    @FXML
    public TableView<EventCoordinator> adminEventMangerTableView;
    @FXML
    public TableColumn<EventCoordinator, String> adminEventMangerTableViewName;
    @FXML
    public TableColumn<EventCoordinator, String> adminEventMangerTableViewLastname;
    @FXML
    public TableColumn<EventCoordinator, String> adminEventMangerTableViewEmail;
    @FXML
    public TableColumn<EventCoordinator, String> adminEventMangerTableViewEvents;
    @FXML
    public JFXButton createEventManger;
    @FXML
    public JFXButton editEventManger;
    @FXML
    public JFXButton deletEventManger;
    @FXML
    public JFXButton logOutAdmin;



    public void initialize(URL location, ResourceBundle resources) {
        setAdminEventMangerTableView();


        adminEventMangerTableView.setOnMouseClicked((MouseEvent event) -> {
            setSelectedItems();
        });
    }

    /**m
     * Method used for initializing the EventCoordinator table.
     */
    private void setAdminEventMangerTableView() {

        adminEventMangerTableViewName.setCellValueFactory(new PropertyValueFactory<>("username"));

        adminEventMangerTableViewLastname.setCellValueFactory(new PropertyValueFactory<>("name"));
        adminEventMangerTableView.setItems(eventMangerModel.getAllEventManagers());
    }


    public AdminController() throws IOException {
        eventMangerModel = new EventMangerModel();
    }

    /**
     * Makes an ObservableList that will keep track of the EventManger list
     * @return
     */
    public ObservableList<EventCoordinator> getEventManger() {
        return (ObservableList<EventCoordinator>) adminEventMangerTableView;
    }


    public void createEventMangerBtn(ActionEvent event) throws IOException {
        Stage stage = (Stage) createEventManger.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/newEventManger.fxml"));
        stage.setTitle("Customer");
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    public void editEventMangerBtn(ActionEvent event) {
    }

    public void deletEventMangerBtn(ActionEvent event) {
    }

    public void logOutAdminBtn(ActionEvent event) throws IOException {
        Stage switcher = (Stage) createEventManger.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/MainLoginView.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("EventCoordinatorManagement");
        switcher.setScene(scene);
    }

    /**
     * Changes selected Name  in the adminEventMangerTableViewName
     */
    private void setSelectedItems() {
        if (adminEventMangerTableView.getSelectionModel().getSelectedItem() != null)
        {
            selectedEventCoordinator = adminEventMangerTableView.getSelectionModel().getSelectedItem();
        }

    }
}
