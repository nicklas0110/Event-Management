package DAL;

import BE.Event;
import BE.EventCoordinator;
import DAL.db.DatabaseConnector;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventCoordinatorDAO {

    private DatabaseConnector DC;


    public EventCoordinatorDAO() throws IOException {
        DC = new DatabaseConnector();
    }


    // This is the method to create a EventCoordinator in the Database. This is also where the EventCoordinator gets an ID.
    public EventCoordinator addEventCoordinator(String userName, String password, String name) throws Exception {
        Connection con = DC.getConnection();


        String sql = "INSERT INTO UserTable (UserName,UserPassword,UserType, name) VALUES (?,?,?,?);";
        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, userName);
        ps.setString(2, password);
        ps.setString(3, "EventCoordinator");
        ps.setString(4, name);
        int affectedRows = ps.executeUpdate();
        if (affectedRows == 1) {
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                EventCoordinator eventCord = new EventCoordinator(id, userName, name);
                return eventCord;
            }

        }
        return null;
    }

    public List<EventCoordinator> getAllEventCoordinators() throws Exception {
        Connection con = DC.getConnection();

        List<EventCoordinator> allCoordinators = new ArrayList<>();


        String sql = "SELECT * FROM UserTable WHERE UserType = 'EventCoordinator'";
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) { // Creates and adds song objects into an array list
            EventCoordinator eventCord = new EventCoordinator(rs.getInt("UserID"), rs.getString("name"), rs.getString("UserName"));
            allCoordinators.add(eventCord);
        }
        return allCoordinators;
    }

    public void removeEventCoordinator(EventCoordinator selectedEventCoordinator) {
        String sql1 = "DELETE FROM UserTable WHERE UserID = (?);";

        try (Connection connection = DC.getConnection()) {
            PreparedStatement ps1 = connection.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);

            ps1.setInt(1, selectedEventCoordinator.getId());

            ps1.executeUpdate();

        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void editEventCoordinator(EventCoordinator selectedEventCoordinator) {

        String sql = "UPDATE UserTable SET UserName= (?), name=(?) WHERE UserID = (?);";
        try (Connection connection = DC.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, selectedEventCoordinator.getUsername());
            statement.setString(2, selectedEventCoordinator.getName());
            statement.setInt(3, selectedEventCoordinator.getId());
            statement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
