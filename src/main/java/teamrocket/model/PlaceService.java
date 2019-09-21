package teamrocket.model;

import teamrocket.util.Util;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


public class PlaceService {

    //Ta metoda może się nam przydać w dalszej pracy

    private static final Path PLACES_PATH = Paths.get(".","src","main","resources","placeRepo.csv");

    //Ta meotda będzie służyć do tworzenia nowego obiektu miejsca np. przy tworzeniu nowego wydarzenia

//    public Place createPlaceObject(int id, String name, String street, String city, int quntityPlaces, int quantityGames, boolean isOpen) {
////        return new Place(id, name, street, city, quntityPlaces, quantityGames, isOpen);
//    }

    //Metoda służąca dodawaniu miejsc do bazy dancyh miejsc

    public void addPlaces(Place place) throws IOException {
        String placeString = place.toString() + "\n";
        Util.writeToFile(PLACES_PATH, placeString.getBytes());
    }

}
