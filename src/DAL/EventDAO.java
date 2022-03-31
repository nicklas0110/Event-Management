package DAL;

import BE.Event;
import BE.EventCoordinator;
import BLL.EventManager;
import DAL.db.DatabaseConnector;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventDAO {

    public ObservableList<EventCoordinator> getEvents;
    private DatabaseConnector DC;

    public EventDAO() throws IOException
    {
        DC = new DatabaseConnector();
    }

    public Event addEvent(String event, String start, String eventTime, String location, String eventinfo) throws SQLException {
        Connection connection = DC.getConnection();

        String sql = "INSERT INTO EventTable (EventName,EventDato,EventTime,EventLocation,EventNotes,event) VALUES (?,?,?,?,?,?);";
        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, event);
        ps.setString(2, start);
        ps.setString(3, eventTime);
        ps.setString(4, location);
        ps.setString(5, eventinfo);
        ps.setString(6, "event");
        int affectedRows = ps.executeUpdate();
        if (affectedRows == 1) {
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int eventId = rs.getInt(1);
                Event eventCord = new Event(eventId, event, start,eventTime,location,eventinfo);
                return eventCord;
            }

        }
        return null;
    }

    public void updateEvent(Event updateEvent) {

        String sql = "UPDATE EventTable SET EventName= (?), EventTime=(?), EventLocation=(?), EventNotes WHERE UserID = (?);";
        try (Connection connection = DC.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, updateEvent.getEventId());
            statement.setString(2, updateEvent.getEventName());
            statement.setString(3, updateEvent.getEventLocation());
            statement.setString(4, updateEvent.getEventDate());
            //statement.setString(5, updateEvent.getEventTime(););
            statement.setString(5, updateEvent.getEventInfo());
            statement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Event> getAllEvents() throws Exception {
        Connection con = DC.getConnection();

        List<Event> allCoordinators = new ArrayList<>();


        String sql = "SELECT * FROM EventTable WHERE event = 'event'";
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) { // Creates and adds song objects into an array list
            Event eventCord = new Event(rs.getInt("EventID"), rs.getString("EventName"),
                    rs.getString("EventTime"), rs.getString("EventDato"), rs.getString("EventLocation"),
                    rs.getString("EventNotes"));
            allCoordinators.add(eventCord);
        }
        return allCoordinators;
    }



    public void removeEvent(Event selectedEvent) {
        String sql1 = "DELETE FROM EventTable WHERE EventID = (?);";

        try (Connection connection = DC.getConnection()) {
            PreparedStatement ps1 = connection.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);

            ps1.setInt(1, selectedEvent.getEventId());

            ps1.executeUpdate();

        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
