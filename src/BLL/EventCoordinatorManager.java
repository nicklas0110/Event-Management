package BLL;

import BE.EventCoordinator;
import DAL.EventMangerDAO;
import javafx.beans.InvalidationListener;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.*;

public class EventCoordinatorManager {
    EventMangerDAO eventMangerDAO = new EventMangerDAO();

    private StringProperty userName = new SimpleStringProperty();
    private StringProperty name = new SimpleStringProperty();

    public EventCoordinatorManager() throws IOException {
    }

    // here we create a movie with the input from the gui, sending it to Dal.
    public EventCoordinator addEventManger(String userName, String password, String name) throws Exception
    {
        return (eventMangerDAO.addEventManger(userName, password, name));
    }

    public ObservableList<EventCoordinator> getAllEventManagers() {
        ObservableList<EventCoordinator> eventObs = FXCollections.observableArrayList();

        try {
            eventObs.addAll(eventMangerDAO.getAllEventManagers());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eventObs;
    }

    public void removeEventManger(EventCoordinator selectedEventCoordinator) {
        eventMangerDAO.removeEventManger(selectedEventCoordinator);
    }
}
