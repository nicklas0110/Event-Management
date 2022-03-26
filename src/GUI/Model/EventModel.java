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
