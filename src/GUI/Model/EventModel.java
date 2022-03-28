package GUI.Model;

import BE.Event;
import BLL.EventManager;

import java.io.IOException;
import java.util.List;

public class EventModel {

    private final EventManager eventManager;


    public EventModel() throws IOException {
        eventManager = new EventManager();
    }

    public static void addEvent(String id, String event, Double date, String start, String location) {


    }

    public void editEvent(Event event) {
        EventManager.editEvent(event);
    }

    /*
    public List<Event> getEvents() {
        List<Event> allEvents = eventManager.getEvents();
        return allEvents;
    }
    
     */
}
