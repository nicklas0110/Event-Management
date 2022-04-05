package DAL;

import DAL.db.DatabaseConnector;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class TicketDAO {

    private DatabaseConnector DC;

    public TicketDAO() throws IOException {
        DC = new DatabaseConnector();
    }


    public void createTicket(String ticketType, String ticketPicture, int eventId, int customerId) throws Exception {

    }
}

