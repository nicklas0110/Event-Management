package BLL;

import BE.EventCoordinator;
import DAL.EventCoordinatorDAO;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

public class EventCoordinatorCoordinator {
    EventCoordinatorDAO eventCoordinatorDAO = new EventCoordinatorDAO();

    private StringProperty userName = new SimpleStringProperty();
    private StringProperty name = new SimpleStringProperty();

    public EventCoordinatorCoordinator() throws IOException {
    }

    // here we create a EventCoordinator with the input from the gui, sending it to Dal.
    public EventCoordinator addEventCoordinator(String userName, String password, String name) throws Exception
    {
        return (eventCoordinatorDAO.addEventCoordinator(userName, password, name));
    }

    public ObservableList<EventCoordinator> getAllEventCoordinators() {
        ObservableList<EventCoordinator> eventObs = FXCollections.observableArrayList();

        try {
            eventObs.addAll(eventCoordinatorDAO.getAllEventCoordinators());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eventObs;
    }

    public void removeEventCoordinator(EventCoordinator selectedEventCoordinator) {
        eventCoordinatorDAO.removeEventCoordinator(selectedEventCoordinator);
    }
}
