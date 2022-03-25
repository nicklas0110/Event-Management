package GUI.Model;

import BE.EventCoordinator;
import BLL.EventCoordinatorManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

public class EventCoordinatorModel {
    private ObservableList<EventCoordinator> eventCoordinatorList = FXCollections.observableArrayList();;

    private EventCoordinatorManager eventCEventCoordinator;


    public EventCoordinatorModel() {
        try {
            eventCEventCoordinator = new EventCoordinatorManager();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<EventCoordinator> getAllEventCoordinator(){
        ObservableList<EventCoordinator> allEventCords = eventCEventCoordinator.getAllEventManagers();
        eventCoordinatorList = allEventCords;
        return allEventCords;
    }


    public void addEventCoordinator(String userName, String password, String name) throws Exception {
        eventCoordinatorList.add(eventCEventCoordinator.addEventManger(userName, password, name));
    }

    public void removeEventCoordinator(EventCoordinator selectedEventCoordinator) {
        eventCEventCoordinator.removeEventManger(selectedEventCoordinator);
        eventCoordinatorList.remove(selectedEventCoordinator);
    }
}
