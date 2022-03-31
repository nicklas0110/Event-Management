package GUI.Model;

import BE.EventCoordinator;
import BLL.EventCoordinatorCoordinator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

public class EventCoordinatorModel {
    private ObservableList<EventCoordinator> eventCoordinatorList = FXCollections.observableArrayList();;

    private EventCoordinatorCoordinator eventCoordinatorLm;


    public EventCoordinatorModel() {
        try {
            eventCoordinatorLm = new EventCoordinatorCoordinator();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<EventCoordinator> getAllEventCoordinator(){
        ObservableList<EventCoordinator> allEventCords = eventCoordinatorLm.getAllEventCoordinators();
        eventCoordinatorList = allEventCords;
        return allEventCords;
    }


    public void addEventCoordinator(String userName, String password, String name) throws Exception {
        eventCoordinatorList.add(eventCoordinatorLm.addEventCoordinator(userName, password, name));
    }

    public void removeEventCoordinator(EventCoordinator selectedEventCoordinator) {
        eventCoordinatorLm.removeEventCoordinator(selectedEventCoordinator);
        eventCoordinatorList.remove(selectedEventCoordinator);
    }

    public void updateEventCoordinator(EventCoordinator selectedEventCoordinator) {
        eventCoordinatorLm.updateEventCoordinator(selectedEventCoordinator);
        eventCoordinatorList.clear();
        eventCoordinatorList.addAll(eventCoordinatorLm.getAllEventCoordinators());
    }
}
