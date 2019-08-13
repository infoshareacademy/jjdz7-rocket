package main;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Place {

    private int id;
    private String name;
    private String street;
    private String city;
    private int quantityPlaces;
    private int quantityGames;
    private boolean isOpen;

    public Place(int id, String name, String street, String city, int quantityPlaces, int quantityGames, boolean isOpen) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.city = city;
        this.quantityPlaces = quantityPlaces;
        this.quantityGames = quantityGames;
        this.isOpen = isOpen;
    }

    //gettery


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public int getQuantityPlaces() {
        return quantityPlaces;
    }

    public int getQuantityGames() {
        return quantityGames;
    }

    public boolean isOpen() {
        return isOpen;
    }
//settery

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setQuantityPlaces(int quantityPlaces) {
        this.quantityPlaces = quantityPlaces;
    }

    public void setQuantityGames(int quantityGames) {
        this.quantityGames = quantityGames;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public String getAdress(){
        return street + city;
    }
// Ta metoda może się przydać przy ustalaniu wydarzenia.
// Jeżeli w danym lokalu nie będzie gier to wyświetli się informacja o potrzebie przyniesienia gier
    public String checkGames(){
        if (quantityGames == 0){
            return "You need games";
        }
    }
    //Ta metoda może się nam przydać w dalszej pracy
    private static final Path PLACES_PATH = Paths.get("./src/main/database/PlacesDatabase.xml");
}