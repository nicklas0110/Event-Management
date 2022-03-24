package GUI.Model;

import BE.EventCoordinator;
import BLL.EventCoordinatorManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

public class EventMangerModel {
    private ObservableList<EventCoordinator> eventManagerList = FXCollections.observableArrayList();;

    private EventCoordinatorManager eventCEventCoordinator;

    public EventMangerModel(ObservableList<EventCoordinator> eventManagerList, EventCoordinatorManager eventCEventCoordinator) throws IOException {
        eventCEventCoordinator = new EventCoordinatorManager();
    }

    public EventMangerModel() {
        try {
            eventCEventCoordinator = new EventCoordinatorManager();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<EventCoordinator> getAllEventManagers(){
        ObservableList<EventCoordinator> allEventCords = eventCEventCoordinator.getAllEventManagers();
        eventManagerList = allEventCords;
        return allEventCords;
    }

    /**
     * Makes an ObservableList that will keep track of the movie list
     * @return
     */
    public ObservableList<EventCoordinator> geteventManagerList() {
        return eventManagerList;
    }



    public void addEventManger(String userName, String password, String name) throws Exception {
        eventManagerList.add(eventCEventCoordinator.addEventManger(userName, password, name));
    }
}
