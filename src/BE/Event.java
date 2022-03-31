package BE;

public class Event {

    private int eventId;
    private String EventName;
    private String EventDate;
    private String EventTime;
    private String EventLocation;
    private String EventInfo;

    public Event(int eventId, String eventName, String eventDate, String eventTime, String eventLocation, String eventInfo) {
        this.eventId = eventId;
        this.EventName = eventName;
        this.EventDate = eventDate;
        this.EventTime = eventTime;
        this.EventLocation = eventLocation;
        this.EventInfo = eventInfo;

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



    public String getEventDate() {
       return  EventDate;
    }

    public void setEventDate(String eventDate) {
        this.EventDate = eventDate;
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
