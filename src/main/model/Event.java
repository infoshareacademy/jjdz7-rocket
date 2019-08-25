package main.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Event {

    private String eventName;
    private EventType eventType;
    private String eventDescription;
    private Game gameName;
    private int playersNumber;
    private LocalDate eventDate;
    private LocalTime eventTime;
    private Place eventPlace;

    public Event(String eventName, EventType eventType, String eventDescription, Game gameName, int playersNumber, LocalDate eventDate, LocalTime eventTime, Place eventPlace) {
        this.eventName = eventName;
        this.eventType = eventType;
        this.eventDescription = eventDescription;
        this.gameName = gameName;
        this.playersNumber = playersNumber;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.eventPlace = eventPlace;
    }

    public Event(String eventName, LocalDate eventDate, LocalTime eventTime, Place eventPlace) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.eventPlace = eventPlace;
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

    public Game getGameName() {
        return gameName;
    }

    public int getPlayersNumber() {
        return playersNumber;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public LocalTime getEventTime() {
        return eventTime;
    }

    public Place getEventPlace() {
        return eventPlace;
    }


    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public void setGameName(Game gameName) {
        this.gameName = gameName;
    }

    public void setPlayersNumber(int playersNumber) {
        this.playersNumber = playersNumber;
    }
}
