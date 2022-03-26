package BLL;

import BE.Event;
import DAL.EventDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class EventManager {
    private EventDAO eventDAO;

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
    public static void editEvent(Event event) {
    }

}
