package teamrocket.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class    Event {

    private static final String DELIMITER = " ! ";

    private String eventName;
    private EventType eventType;
    private String eventDescription;
    private String gameName;
    private int playersNumber;
    private LocalDate eventDate;
    private LocalTime eventStartTime;
    private LocalTime eventEndTime;
//    private String eventPlaceName;
    private String eventAddress;
    private String eventCity;


    public Event() {
    }

    public Event(String formattedEvent) {
        if (formattedEvent.contains ( DELIMITER )) {
            String[] splitEventParameters = formattedEvent.split ( DELIMITER );
            this.eventName = splitEventParameters[0];
            this.eventType = splitEventParameters[1];
            this.eventDescription = splitEventParameters[2];
            this.gameName = splitEventParameters[3];
            this.playersNumber = Integer.parseInt(splitEventParameters[4]);
            this.eventDate = LocalDate.parse(splitEventParameters[5]);
            this.eventStartTime = LocalTime.parse(splitEventParameters[6]);
            this.eventEndTime = LocalTime.parse(splitEventParameters[7]);
            this.eventAddress = splitEventParameters[8];
            this.eventCity = splitEventParameters[9];
        }
    }

    public String getEventName() {
        return eventName;
    }

    public EventType getEventType() {
        return eventType;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public String getGameName() {
        return gameName;
    }

    public int getPlayersNumber() {
        return playersNumber;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public LocalTime getEventStartTime() {
        return eventStartTime;
    }

    public LocalTime getEventEndTime() {
        return eventEndTime;
    }

    public String getEventAddress() {
        return eventAddress;
    }

    public String getEventCity() {
        return eventCity;
    }
}

