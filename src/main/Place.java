package main;

public class Place {

    private String name;
    private String street;
    private String city;
    private int quantityPlaces;
    private int quantityGames;
    private boolean isOpen;

    public Place(String name, String street, String city, int quantityPlaces, int quantityGames, boolean isOpen) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.quantityPlaces = quantityPlaces;
        this.quantityGames = quantityGames;
        this.isOpen = isOpen;
    }
//gettery
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

    public String ckeckGames(){
        if (quantityGames == 0){
            return "You need games";
        }
    }

}