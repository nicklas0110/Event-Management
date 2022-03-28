package GUI.Model;

import BE.Event;
import BE.EventCoordinator;
import BLL.EventManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.SQLException;

public class EventModel {

    private ObservableList<Event> eventList = FXCollections.observableArrayList();

    private EventManager eventManager;


    public EventModel() throws IOException {
        eventManager = new EventManager();
    }


    public void addEvent(String event, String start, String eventTime, String location, String eventInfo) throws SQLException {
        eventList.add(eventManager.createEvent(event, start, eventTime, location, eventInfo));
     }

    public void editEvent(Event event) {
    }

    public ObservableList<Event> getAllEvents() throws IOException {
       eventList = eventManager.getAllEvents();
       return eventList;
    }

    public void removeEvent(Event selectedEvent) {
        eventManager.removeEvent(selectedEvent);
        eventList.remove(selectedEvent);
    }





    /*
    public List<Event> getEvents() {
        List<Event> allEvents = eventManager.getEvents();
        return allEvents;
    }
    
     */
}
