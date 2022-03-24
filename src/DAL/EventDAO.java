package DAL;

import DAL.db.DatabaseConnector;

import java.io.IOException;

public class EventDAO {

    private DatabaseConnector DC;

    public EventDAO() throws IOException
    {
        DC = new DatabaseConnector();
    }

}
