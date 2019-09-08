package teamrocket.model;

import teamrocket.util.Util;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class EventService {
    private static final Path EVENT_PATH = Paths.get ("./src/main/java/teamrocket/repositories/eventRepository");

    public Event createEventObject(String eventName, LocalDate eventDate, LocalTime eventTime) {

        return new Event(eventName, eventDate, eventTime);
    }

//    String eventName;
//    private EventType eventType;
//    private String eventDescription;
//    private Game gameName;
//    private int playersNumber;
//    private LocalDate eventDate;
//    private LocalTime eventTime;
//    private Place eventPlace;

    public Event getEventFromConsole() {
        String eventName = Util.readInputWithMessage("Nazwa: ");
        LocalDate eventDate = Util.readInputDateWithMessage("Data wydarzenia: ");
        LocalTime eventTime = Util.readInputTimeWithMessage("Godzina wydarzenia: ");
        return createEventObject(eventName, eventDate, eventTime);
    }

    public void addEvent(Event event) throws IOException {
        String eventString = event.toString() + "\n";
        Util.writeToFile(EVENT_PATH, eventString.getBytes());
    }


    //wyświetlanie listy
    public Event [] showEvent() throws IOException {
        List<String> eventList = Util.readFileContent(EVENT_PATH); //String!!!

        Event[] eventsArray = new Event[eventList.size()];

        for(int i = 0 ; i < eventsArray.length ; i++){
            eventsArray[i] = new Event(eventList.get(i));
        }

        return eventsArray;
    }



}




