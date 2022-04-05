package BE;

public class Ticket {

    private int ticketID;
    private String ticketType;
    private int eventID;
    private int customerID;
    private String ticketPicture;

    public Ticket(int ticketID, String ticketType, int eventID, int customerID, String ticketPicture) {
        this.ticketID = ticketID;
        this.ticketType = ticketType;
        this.eventID = eventID;
        this.customerID = customerID;
        this.ticketPicture = ticketPicture;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getTicketPicture() {
        return ticketPicture;
    }

    public void setTicketPicture(String ticketPicture) {
        this.ticketPicture = ticketPicture;
    }
}
