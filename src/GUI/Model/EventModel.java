package GUI.Model;

import BE.Event;
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
        eventList.add(eventManager.addEvent(event, start, eventTime, location, eventInfo));
     }

    public void editEvent(Event event) {
    }

    /*
    public List<Event> getEvents() {
        List<Event> allEvents = eventManager.getEvents();
        return allEvents;
    }
    
     */
}
