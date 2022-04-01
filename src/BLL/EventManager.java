package BLL;

import BE.Event;
import DAL.EventDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.SQLException;

public class EventManager {
    EventDAO eventDAO = new EventDAO();
    /**
     * Constructor
     * @throws IOException
     */
    public EventManager() throws IOException {
        eventDAO = new EventDAO();
    }


    public void editEvent(Event selectedEvents) {
        eventDAO.editEvent(selectedEvents);
    }



    //create event in eventMannager
    public Event createEvent(String event, String start, String eventTime, String location, String eventInfo) throws SQLException {
        return (eventDAO.addEvent(event,start,eventTime,location,eventInfo));
    }

    public void removeEvent(Event selectedEvent) {
        eventDAO.removeEvent(selectedEvent);
    }

    public ObservableList<Event> getAllEvents() {
        ObservableList<Event> eventObs = FXCollections.observableArrayList();

        try {
            eventObs.addAll(eventDAO.getAllEvents());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eventObs;
    }
}
