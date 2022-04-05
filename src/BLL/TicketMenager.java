package BLL;

import DAL.TicketDAO;

import java.sql.SQLException;

public class TicketMenager {

    private TicketDAO ticketDAO;

    public TicketMenager(TicketDAO ticketDAO) {
        this.ticketDAO = ticketDAO;
    }


}
