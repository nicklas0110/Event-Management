package DAL;

import BE.Event;
import BE.EventCoordinator;
import DAL.db.DatabaseConnector;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EventMangerDAO {

    private DatabaseConnector DC;


    public EventMangerDAO() throws IOException
    {
        DC = new DatabaseConnector();
    }



    // This is the method to create a movie in the Database. This is also where the movie gets an ID.
    public EventCoordinator addEventManger(String userName, String password, String name) throws Exception
    {
        Connection con = DC.getConnection();


        String sql = "INSERT INTO UserTable (UserName,UserPassword,UserType, name) VALUES (?,?,?,?);";
        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, userName);
        ps.setString(2, password);
        ps.setString(3, "EventCoordinator");
        ps.setString(4, name);
        int affectedRows = ps.executeUpdate();
        if (affectedRows == 1)
        {
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next())
            {
                int id = rs.getInt(1);
                EventCoordinator eventCord = new EventCoordinator(id, userName, name);
                return eventCord;
            }

        }
        return null;
    }

    public List<EventCoordinator> getAllEventManagers() throws Exception {
        Connection con = DC.getConnection();

        List<EventCoordinator> allCoordinators = new ArrayList<>();


        String sql = "SELECT * FROM UserTable WHERE UserType = 'EventCoordinator'";
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) { // Creates and adds song objects into an array list
            EventCoordinator eventCord = new EventCoordinator(rs.getInt("UserID"),rs.getString("UserName"),rs.getString("name"));
            allCoordinators.add(eventCord);
        }
        return allCoordinators;
    }
}
