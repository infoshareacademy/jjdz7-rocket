package teamrocket.model;

import teamrocket.util.Util;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Event {

    private static final Path EVENTREPO_PATH = Paths.get(".","src","main","resources", "eventRepository.csv");
    private static final String DELIMITER = ";";
    private int eventId;
    private String eventName;
    private String eventType;
    private String eventDescription;
    private String gameName;
    private int playersNumber;
    private LocalDate eventDate;
    private LocalTime eventTime;
    private Place eventPlace;
    private LocalTime eventStartTime;
    private LocalTime eventEndTime;
    private String eventPlaceName;
    private String eventAddress;
    private String eventCity;
    private static List<Event> eventsArray = new ArrayList<>();

    public Event(String eventName, String eventDescription, String gameName, int playersNumber, LocalDate eventDate, LocalTime eventStartTime, LocalTime eventEndTime, String eventPlaceName, String eventAddress, String eventCity) {
        this.eventName = eventName;
        this.eventType = eventType;
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
            this.eventId = Integer.parseInt(splitEventParameters[0]);
            this.eventName = splitEventParameters[1];
            this.eventType =  splitEventParameters[2];
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

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
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

    public LocalTime getEventTime() {
        return eventTime;
    }

    public void setEventTime(LocalTime eventTime) {
        this.eventTime = eventTime;
    }

    public Place getEventPlace() {
        return eventPlace;
    }

    public void setEventPlace(Place eventPlace) {
        this.eventPlace = eventPlace;
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

    public static List<Event> createArrayFromRepo() {
        List<String> eventList = null;
        try {
            eventList = Util.readFileContent(EVENTREPO_PATH);
        } catch (IOException e) {
            System.out.println("Zła ścieżka do pliku lub plik nie istnieje.");
            ;
        }
        for (int i = 0; i < eventList.size(); i++) {
            eventsArray.add(new Event(eventList.get(i)));
        }
        return eventsArray;
    }

    private static void printHeading() {
        System.out.println("ID  |" +
                " Nazwa Wydarzenia                                          " +
                "| Typ Wydarzenia    " +
                "| Data Wydarzenia ");
    }

    private static void printEvents(Event event) {
        System.out.print(Util.addSpaces(5, String.valueOf(event.getEventId())));
        System.out.print(Util.addSpaces(60, event.getEventName()));
        System.out.print(Util.addSpaces(20, String.valueOf(event.getEventType())));
        System.out.print(Util.addSpaces(30, String.valueOf(event.getEventDate())));
        System.out.print("\n");
    }

    public static void showAllEvents() {
        printHeading();
        for (Event event : eventsArray) {
            printEvents(event);
        }
    }

    public static void filterEventByDate(){
            System.out.println("Wpisz datę, po której chciałbyś filtrować wydarzenia:  ");
            String userInput = Util.readUserInput();
            printHeading();
            for (Event event : eventsArray)
                if (event.getEventDate().toString().toLowerCase().contains(userInput.toLowerCase())) printEvents(event);
        }

    public static void filterEventsByType() {
            System.out.println("Wpisz typ wydarzenia, po którym chciałbyś filtrować wydarzenia: ");
            String userInput = Util.readUserInput();
            printHeading();
            for (Event event : eventsArray)
                if (event.getEventType().toLowerCase().contains(userInput.toLowerCase())) printEvents(event);
        }


    @Override
    public String toString() {
        final String delimiter = ";";
        StringBuilder event = new StringBuilder();
        return event.append(eventId).append(delimiter)
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

