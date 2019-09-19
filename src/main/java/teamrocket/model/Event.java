package teamrocket.model;

import teamrocket.util.Util;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Event {

    private static final Path EVENTREPO_PATH = Paths.get("./src/main/repositories/eventRepository.csv");
    private static final String DELIMITER = ";";
    private int eventId;
    private String eventName;
    private EventType eventType;
    private String eventDescription;
    private Game gameName;
    private int playersNumber;
    private LocalDate eventDate;
    private LocalTime eventTime;
    private Place eventPlace;
    private static List<Event> eventsArray = new ArrayList<>();


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
    // TODO Event constructor
    public Event(String formattedEvent) {
        if (formattedEvent.contains(DELIMITER)) {
            String[] splitEventParameters = formattedEvent.split(DELIMITER);
            this.eventId = parseInt(splitEventParameters[0]);
            this.eventName = splitEventParameters[1];
//            this.eventType = splitEventParameters[2]; // do ogarniecia jak enuma tu wrzucic
            this.eventDescription = splitEventParameters[3];
//            this.= splitEventParameters[4]; nie wiem co ta kolumna reprezentuje.
            this.eventDate = parseInt(splitEventParameters[5]);
            this.eventTime = parseInt(splitEventParameters[6]);
            this.eventTIme2 = parseInt(splitEventParameters[7]);
            this.eventPlace.getPlaceName() = splitEventParameters[8];
            this.eventPlace.getPlaceStreet() = splitEventParameters[9];
            this.eventPlace.getPlaceCity() = splitEventParameters[10];
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

    public Game getGameName() {
        return gameName;
    }

    public void setGameName(Game gameName) {
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

    public List<Event> createArrayFromRepo() {
        List<String> eventList = null;
        try {
            eventList = Util.readFileContent(EVENTREPO_PATH);
        } catch (IOException e) {
            System.out.println("Wrong Path to Repo file or repo doesn't exist");
            ;
        }
        for (int i = 0; i < eventList.size(); i++) {
            eventsArray.add(new Event(eventList.get(i)));
        }
        return eventsArray;
    }

    private void printHeading() {
        System.out.println("EVENT_ID  |" +
                " EVENT_NAME                                                                               " +
                "| EVENT_TYPE           " +
                "| EVENT_DATE ");
    }

    private void printEvents(Event event) {
        System.out.print(Util.addSpaces(10, String.valueOf(event.getEventId())));
        System.out.print(Util.addSpaces(90, event.getEventName()));
        System.out.print(Util.addSpaces(30, String.valueOf(event.getEventType())));
        System.out.print(Util.addSpaces(30, String.valueOf(event.getEventDate())));
        System.out.print("\n");
    }

    public void showAllEvents() {
        printHeading();
        for (Event event : eventsArray) {
            printEvents(event);
        }
    }

    public void filterEventByDate(){
            System.out.println("Type date by which You would like to filter the Events' database: ");
            String userInput = Util.readUserInput();
            printHeading();
            for (Event event : eventsArray)
                if (event.getEventDate().toLowerCase().contains(userInput.toLowerCase())) printEvents(event);
        }

    public void filterEventsByType() {
            System.out.println("Type Event type by which You would like to filter the Events' database: ");
            String userInput = Util.readUserInput();
            printHeading();
            for (Event event : eventsArray)
                if (event.getEventType().toLowerCase().contains(userInput.toLowerCase())) printEvents(event);
        }


}
