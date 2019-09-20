package teamrocket.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class    Event {

    private static final String DELIMITER = " ; ";

    private Integer eventID;
    private String eventName;
    private EventType eventType;
    private String eventDescription;
    private String gameName;
    private int playersNumber;
    private LocalDate eventDate;
    private LocalTime eventStartTime;
    private LocalTime eventEndTime;
    private String eventPlaceName;
    private String eventAddress;
    private String eventCity;


    public Event() {
    }

    public Event(String eventName, String eventDescription, String gameName, int playersNumber, LocalDate eventDate, LocalTime eventStartTime, LocalTime eventEndTime, String eventPlaceName, String eventAddress, String eventCity) {
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.gameName = gameName;
        this.playersNumber = playersNumber;
        this.eventDate = eventDate;
        this.eventStartTime = eventStartTime;
        this.eventEndTime = eventEndTime;
        this.eventPlaceName = eventPlaceName;
        this.eventAddress = eventAddress;
        this.eventCity = eventCity;
    }

    public Event(String formattedEvent) {
        if (formattedEvent.contains ( DELIMITER )) {
            String[] splitEventParameters = formattedEvent.split ( DELIMITER );
            this.eventID = Integer.parseInt(splitEventParameters[0]);
            this.eventName = splitEventParameters[1];
//            this.eventType = splitEventParameters[2];
            this.eventDescription = splitEventParameters[3];
            this.gameName = splitEventParameters[4];
            this.playersNumber = Integer.parseInt(splitEventParameters[5]);
            this.eventDate = LocalDate.parse(splitEventParameters[6]);
            this.eventStartTime = LocalTime.parse(splitEventParameters[7]);
            this.eventEndTime = LocalTime.parse(splitEventParameters[8]);
            this.eventPlaceName = splitEventParameters[9];
            this.eventAddress = splitEventParameters[10];
            this.eventCity = splitEventParameters[11];
        }
    }

    public Integer getEventID() {
        return eventID;
    }

    public void setEventID(Integer eventID) {
        this.eventID = eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public int getPlayersNumber() {
        return playersNumber;
    }

    public void setPlayersNumber(int playersNumber) {
        this.playersNumber = playersNumber;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public LocalTime getEventStartTime() {
        return eventStartTime;
    }

    public void setEventStartTime(LocalTime eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    public LocalTime getEventEndTime() {
        return eventEndTime;
    }

    public void setEventEndTime(LocalTime eventEndTime) {
        this.eventEndTime = eventEndTime;
    }

    public String getEventPlaceName() {
        return eventPlaceName;
    }

    public void setEventPlaceName(String eventPlaceName) {
        this.eventPlaceName = eventPlaceName;
    }

    public String getEventAddress() {
        return eventAddress;
    }

    public void setEventAddress(String eventAddress) {
        this.eventAddress = eventAddress;
    }

    public String getEventCity() {
        return eventCity;
    }

    public void setEventCity(String eventCity) {
        this.eventCity = eventCity;
    }

    @Override
    public String toString() {
        final String delimiter = ";";
        StringBuilder event = new StringBuilder();
        return event.append(eventID).append(delimiter)
                .append(getEventName()).append(delimiter)
                .append(getEventType()).append(delimiter)
                .append(getEventDescription()).append(delimiter)
                .append(getGameName()).append(delimiter)
                .append(getPlayersNumber()).append(delimiter)
                .append(getEventDate()).append(delimiter)
                .append(getEventStartTime()).append(delimiter)
                .append(getEventEndTime()).append(delimiter)
                .append(getEventPlaceName()).append(delimiter)
                .append(getEventAddress()).append(delimiter)
                .append(getEventCity())
                .toString();
    }
}

