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




    // its is used to get the list in eventDAO.

    /*
    public List<Event> getEvents() {
        List<Event> allEvents = eventDAO.getEvents();
        return allEvents;
    }

     */

    // it is used to Creates an event by using the createEvent method in eventDAO
    /*
    public void createEvent (String eventName, String eventDate, String eventTime, String eventLocation, String eventInfo) throws SQLException {
        eventDAO.createEvent(eventName, eventDate, eventTime, eventLocation, eventInfo);
    }

     */

    //Deletes a event using the deleteEvent methods in eventDAO
     /*
    public void deleteEvent(int id) {
        eventDAO.deleteEvent(id);
    }
      */


     //Edits an event using the editEvent from eventDAO
 /*
    public void editEvent(Event event) {
        eventDAO.editEvent(event);
    }
    */

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
