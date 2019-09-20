package teamrocket.model;

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
    private static final Path EVENT_PATH = Paths.get ("./src/main/repositories/eventRepository.csv");

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
        Integer nextId = maxId + 1;

        return nextId;
    }

    public Event createEventObject(String eventName, String eventDescription, String gameName, int playersNumber, LocalDate eventDate, LocalTime eventStartTime, LocalTime eventEndTime, String eventPlaceName, String eventAddress, String eventCity) {
        return new Event(eventName, eventDescription, gameName, playersNumber, eventDate, eventStartTime, eventEndTime, eventPlaceName, eventAddress, eventCity);
    }

    public Event getEventFromConsole() {
        String eventName = Util.readInputWithMessage("Nazwa wydarzenia: ");
        String eventDescription = Util.readInputWithMessage("Opis wydarzenia: ");
        String gameName = Util.readInputWithMessage("Gra: ");
        int playersNumber = Util.readInputIntegerWithMessage("Liczba graczy: ");
        LocalDate eventDate = Util.readInputDateWithMessage("Data wydarzenia RRRR-MM-DD: ");
        LocalTime eventStartTime = Util.readInputTimeWithMessage("Godzina rozpoczęcia wydarzenia GG:MM: ");
        LocalTime eventEndTime = Util.readInputTimeWithMessage("Godzina zakończenia wydarzenia GG:MM: ");
        String eventPlaceName = Util.readInputWithMessage("Nazwa miejsca wydarzenia: ");
        String eventAddress = Util.readInputWithMessage("Adres: ");
        String eventCity = Util.readInputWithMessage("Miasto: ");

        return createEventObject (eventName, eventDescription, gameName, playersNumber, eventDate, eventStartTime, eventEndTime, eventPlaceName, eventAddress, eventCity);
    }

    public void addEvent(Event event, int eventId) throws IOException {
        event.setEventID(eventId);
        String eventString = event.toString() + "\n";
        Util.writeToFile(EVENT_PATH, eventString.getBytes());
        System.out.println("Wydarzenie zostało dodane");
    }

    /* TODO:
        złapać wyjątki przy złym formacie wpisania daty i czasu (np. data nie może być starsza niż aktualna)
        pętla while w wyjątkach (żeby np. można było pomylić się więcej niż 1 raz)
        typ gry pobrać z enum'a
        nazwę gry ma docelowo pobierać z listy (wyszukiwanie po tytułach) lub można wpisać własną
        nazwa miejsca - docelowo ma wyświetlać się lista placówek gdzie można grać w gry (wtedy automatycznie ma się wstawić adres danego miejsca) lub można wpisać własną
        if null - część pól będzie mogła być pusta (nie każdy chce wszystko uzupełniać), część jest obowiązkowa i musi być wpisana (nazwa wydarzenia, data i czas rozpoczęcia, adres, miasto)
        data - wyskakuje kalendarz; godzina podobnie -licznik
     */



    //wyświetlanie listy
//        public Event [] showEvent() throws IOException {
//        List<String> eventList = Util.readFileContent(EVENT_PATH);
//        Event[] eventsArray = new Event[eventList.size()];
//        for(int i = 0 ; i < eventsArray.length ; i++){
//            eventsArray[i] = new Event(eventList.get(i));
//        } return eventsArray;
//    }

}




