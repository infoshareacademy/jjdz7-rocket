package teamrocket.model;

public class Place {

    private static int placeID;
    private static String placeName;
    private static String placeStreet;
    private static String placeCity;
    private static int quantityPlacesOfPlace;
    private static int quantityGamesOfPlace;


    public Place(int id, String name, String street, String city, int quntityPlaces, int quantityGames, boolean isOpen) {
    }

    public static int getPlaceID() {
        return placeID;
    }

    public static String getPlaceName() {
        return placeName;
    }

    public static String getPlaceStreet() {
        return placeStreet;
    }

    public static String getPlaceCity() {
        return placeCity;
    }

    public static int getQuantityPlacesOfPlace() {
        return quantityPlacesOfPlace;
    }

    public static int getQuantityGamesOfPlace() {
        return quantityGamesOfPlace;
    }

    public void setPlaceID() {
        this.placeID = placeID;
    }

    public void setPlaceName() {
        this.placeName = placeName;
    }

    public void setPlaceStreet() {
        this.placeStreet = placeStreet;
    }

    public void setPlaceCity() {
        this.placeCity = placeCity;
    }

    public void setQuantityPlacesOfPlace() {
        this.quantityPlacesOfPlace = quantityPlacesOfPlace;
    }

    public void setQuantityGamesOfPlace() {
        this.quantityGamesOfPlace = quantityGamesOfPlace;
    }

    public String getAdress() {
        return placeStreet + " " + placeCity;
    }

}
