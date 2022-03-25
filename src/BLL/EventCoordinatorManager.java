package BLL;

import BE.EventCoordinator;
import DAL.EventCoordinatorDAO;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

public class EventCoordinatorManager {
    EventCoordinatorDAO eventCoordinatorDAO = new EventCoordinatorDAO();

    private StringProperty userName = new SimpleStringProperty();
    private StringProperty name = new SimpleStringProperty();

    public EventCoordinatorManager() throws IOException {
    }

    // here we create a movie with the input from the gui, sending it to Dal.
    public EventCoordinator addEventManger(String userName, String password, String name) throws Exception
    {
        return (eventCoordinatorDAO.addEventManger(userName, password, name));
    }

    public ObservableList<EventCoordinator> getAllEventManagers() {
        ObservableList<EventCoordinator> eventObs = FXCollections.observableArrayList();

        try {
            eventObs.addAll(eventCoordinatorDAO.getAllEventManagers());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eventObs;
    }

    public void removeEventManger(EventCoordinator selectedEventCoordinator) {
        eventCoordinatorDAO.removeEventManger(selectedEventCoordinator);
    }
}
