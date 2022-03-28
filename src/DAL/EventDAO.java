package DAL;

import BE.Event;
import BE.EventCoordinator;
import BLL.EventManager;
import DAL.db.DatabaseConnector;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.*;

public class EventDAO {

    private DatabaseConnector DC;

    public EventDAO() throws IOException
    {
        DC = new DatabaseConnector();
    }

    public Event addEvent(String event, String start, String eventTime, String location, String eventinfo) throws SQLException {
        Connection connection = DC.getConnection();

        String sql = "INSERT INTO EventTable (EventName,EventManager,EventTime,EventLocation,EventNotes) VALUES (?,?,?,?,?);";
        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, event);
        ps.setString(2, start);
        ps.setString(3, eventTime);
        ps.setString(4, location);
        ps.setString(5, eventinfo);
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
}
