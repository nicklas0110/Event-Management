package GUI.controller;

import BE.EventCoordinator;
import GUI.Model.EventCoordinatorModel;
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

    private final EventCoordinatorModel eventCoordinatorModel;

    public EventCoordinator selectedEventCoordinator;


    @FXML
    public TableView<EventCoordinator> adminEventCoordinatorTableView;
    @FXML
    public TableColumn<EventCoordinator, String> adminEventCoordinatorTableViewName;
    @FXML
    public TableColumn<EventCoordinator, String> adminEventCoordinatorTableViewLastname;
    @FXML
    public TableColumn<EventCoordinator, String> adminEventCoordinatorTableViewEmail;
    @FXML
    public TableColumn<EventCoordinator, String> adminEventMangerCoordinatorViewEvents;
    @FXML
    public JFXButton createEventCoordinator;
    @FXML
    public JFXButton editEventCoordinator;
    @FXML
    public JFXButton deletEventCoordinator;
    @FXML
    public JFXButton logOutAdmin;



    public void initialize(URL location, ResourceBundle resources) {
        setAdminEventCoordinatorTableView();


        adminEventCoordinatorTableView.setOnMouseClicked((MouseEvent event) -> {
            setSelectedItems();
        });
    }

    /**m
     * Method used for initializing the EventCoordinator table.
     */
    private void setAdminEventCoordinatorTableView() {

        adminEventCoordinatorTableViewName.setCellValueFactory(new PropertyValueFactory<>("username"));

        adminEventCoordinatorTableViewLastname.setCellValueFactory(new PropertyValueFactory<>("name"));
        adminEventCoordinatorTableView.setItems(eventCoordinatorModel.getAllEventCoordinator());
    }


    public AdminController() throws IOException {
        eventCoordinatorModel = new EventCoordinatorModel();
    }

    /**
     * Makes an ObservableList that will keep track of the EventManger list
     * @return
     */
    public ObservableList<EventCoordinator> getEventCoordinator() {
        return (ObservableList<EventCoordinator>) adminEventCoordinatorTableView;
    }


    public void createEventCoordinatorBtn(ActionEvent event) throws IOException {
        Stage stage = (Stage) createEventCoordinator.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/newEventManger.fxml"));
        stage.setTitle("AdminView");
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    public void editEventCoordinatorBtn(ActionEvent event) {
    }
    public void deletEventCoordinatorBtn(ActionEvent event) {
        if (SimpleDialogController.delete() && selectedEventCoordinator != null) {
            eventCoordinatorModel.removeEventCoordinator(selectedEventCoordinator);
        }
    }

    public void logOutAdminBtn(ActionEvent event) throws IOException {
        Stage switcher = (Stage) createEventCoordinator.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/MainLoginView.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("EventCoordinatorManagement");
        switcher.setScene(scene);
    }

    /**
     * Changes selected Name  in the adminEventMangerTableViewName
     */
    private void setSelectedItems() {
        if (adminEventCoordinatorTableView.getSelectionModel().getSelectedItem() != null)
        {
            selectedEventCoordinator = adminEventCoordinatorTableView.getSelectionModel().getSelectedItem();
        }

    }
}
