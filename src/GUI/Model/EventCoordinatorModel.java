package GUI.Model;

import BE.EventCoordinator;
import BLL.EventCoordinatorCoordinator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

public class EventCoordinatorModel {
    private ObservableList<EventCoordinator> eventCoordinatorList = FXCollections.observableArrayList();;

    private EventCoordinatorCoordinator eventCEventCoordinator;


    public EventCoordinatorModel() {
        try {
            eventCEventCoordinator = new EventCoordinatorCoordinator();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<EventCoordinator> getAllEventCoordinator(){
        ObservableList<EventCoordinator> allEventCords = eventCEventCoordinator.getAllEventCoordinators();
        eventCoordinatorList = allEventCords;
        return allEventCords;
    }


    public void addEventCoordinator(String userName, String password, String name) throws Exception {
        eventCoordinatorList.add(eventCEventCoordinator.addEventCoordinator(userName, password, name));
    }

    public void removeEventCoordinator(EventCoordinator selectedEventCoordinator) {
        eventCEventCoordinator.removeEventCoordinator(selectedEventCoordinator);
        eventCoordinatorList.remove(selectedEventCoordinator);
    }
}
