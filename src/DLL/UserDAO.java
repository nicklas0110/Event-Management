package DLL;

import DLL.db.DatabaseConnector;

import java.io.IOException;

public class UserDAO {

    private DatabaseConnector DC;

    public UserDAO() throws IOException
    {
        DC = new DatabaseConnector();
    }
    
}
