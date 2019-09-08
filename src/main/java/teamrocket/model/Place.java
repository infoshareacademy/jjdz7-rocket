package teamrocket.model;

public class Place {

    private int placeID;
    private String placeName;
    private String placeStreet;
    private String placeCity;
    private int quantityPlacesOfPlace;
    private int quantityGamesOfPlace;


    public Place() {
    }
//gettery


    public int getPlaceID() {
        return placeID;
    }

    public String getPlaceName() {
        return placeName;
    }

    public String getPlaceStreet() {
        return placeStreet;
    }

    public String getPlaceCity() {
        return placeCity;
    }

    public int getQuantityPlacesOfPlace() {
        return quantityPlacesOfPlace;
    }

    public int getQuantityGamesOfPlace() {
        return quantityGamesOfPlace;
    }

//settery

    public void setPlaceID(int placeID) {
        this.placeID = placeID;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public void setPlaceStreet(String placeStreet) {
        this.placeStreet = placeStreet;
    }

    public void setPlaceCity(String placeCity) {
        this.placeCity = placeCity;
    }

    public void setQuantityPlacesOfPlace(int quantityPlacesOfPlace) {
        this.quantityPlacesOfPlace = quantityPlacesOfPlace;
    }

    public void setQuantityGamesOfPlace(int quantityGamesOfPlace) {
        this.quantityGamesOfPlace = quantityGamesOfPlace;
    }

    public String getAdress() {
        return placeStreet + " " + placeCity;
    }

    // Ta metoda może się przydać przy ustalaniu wydarzenia.
    // Jeżeli w danym lokalu nie będzie gier to wyświetli się informacja o potrzebie przyniesienia gier
    public String checkGames() {
        if (quantityGamesOfPlace == 0) {
            return "You need games";
        }

        return "";
    }
}
