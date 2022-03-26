package BE;

public class Event {

    private int eventId;
    private String EventName;
    private String EventDato;
    private String EventTime;
    private String EventLocation;
    private String EventInfo;

    public Event(int eventId, String eventName, String eventDato, String eventTime, String eventLocation, String eventInfo) {
        this.eventId = eventId;
        this.EventName = eventName;
        this.EventDato = eventDato;
        this.EventTime = eventTime;
        this.EventLocation = eventLocation;
        this.EventInfo = eventInfo;

    }
    
    

    public Event() {

    }

    public Event(String eventName, String eventDate, String eventTime, String eventLocation, String eventInfo) {
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String eventName) {
        EventName = eventName;
    }

    public String getEventDato() {
        return EventDato;
    }

    public void setEventDato(String eventDato) {
        EventDato = eventDato;
    }

    public void setEventDate(String eventDate) {
        this.EventDato = eventDate;
    }

    public String getEventTime() {
        return EventTime;
    }

    public void setEventTime(String eventTime) {
        EventTime = eventTime;
    }

    public String getEventLocation() {
        return EventLocation;
    }

    public void setEventLocation(String eventLocation) {
        EventLocation = eventLocation;
    }

    public String getEventInfo() {
        return EventInfo;
    }

    public void setEventInfo(String eventInfo) {
        EventInfo = eventInfo;
    }


}
