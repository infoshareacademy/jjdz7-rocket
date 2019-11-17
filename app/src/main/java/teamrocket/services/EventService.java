package teamrocket.services;

import teamrocket.model.Event;
import teamrocket.util.Util;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EventService {
    private static final Path EVENT_PATH = Paths.get(".","app","src","main","resources","eventRepository.csv");

    public int getEventID() throws IOException {
        List<String> linesFromFile = Util.readFileContent(EVENT_PATH);
        List<Integer> ids = new ArrayList<>();

        int recordsCount = linesFromFile.size();
        int counter = 0;

        while (counter <= recordsCount) {
            for (String tempEvent : linesFromFile) {
                String[] eventLine = tempEvent.split(";");
                ids.add(Integer.valueOf(eventLine[0]));
                counter++;
            }
        }
        Integer maxId = Collections.max(ids);
        return maxId + 1;
    }

    private Event createEventObject(String eventName, String eventType, String eventDescription, String gameName, int playersNumber, LocalDate eventDate, LocalTime eventStartTime, LocalTime eventEndTime, String eventPlaceName, String eventAddress, String eventCity) {
        return new Event(eventName, eventType, eventDescription, gameName, playersNumber, eventDate, eventStartTime, eventEndTime, eventPlaceName, eventAddress, eventCity);
    }

    public Event getEventFromConsole() {
        String eventName = Util.readInputWithMessage("Nazwa wydarzenia: ");
        String eventType = Util.readInputWithMessage("Typ wydarzenia: ");
        String eventDescription = Util.readInputWithMessage("Opis wydarzenia: ");
        String gameName = Util.readInputWithMessage("Gra: ");
        int playersNumber = Util.readInputIntegerWithMessage("Liczba graczy: ");
        LocalDate eventDate = Util.readInputDateWithMessage("Data wydarzenia RRRR-MM-DD: ");
        LocalTime eventStartTime = Util.readInputTimeWithMessage("Godzina rozpoczęcia wydarzenia GG:MM: ");
        LocalTime eventEndTime = Util.readInputTimeWithMessage("Godzina zakończenia wydarzenia GG:MM: ");
        String eventPlaceName = Util.readInputWithMessage("Nazwa miejsca wydarzenia: ");
        String eventAddress = Util.readInputWithMessage("Adres: ");
        String eventCity = Util.readInputWithMessage("Miasto: ");

        return createEventObject (eventName, eventType, eventDescription, gameName, playersNumber, eventDate, eventStartTime, eventEndTime, eventPlaceName, eventAddress, eventCity);
    }

    public void addEvent(Event event, int eventId) throws IOException {
        event.setEventId(eventId);
        String eventString = event.toString() + "\n";
        Util.writeToFile(EVENT_PATH, eventString.getBytes());
        System.out.println("Wydarzenie zostało dodane");
    }
}




