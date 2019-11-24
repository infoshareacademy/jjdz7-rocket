package teamrocket;

import teamrocket.menu.Menu;
import teamrocket.model.Event;
import teamrocket.model.Game;
import teamrocket.services.FavouritesService;

import java.io.IOException;

public class App {

    public App(String geek) throws IOException {

    }

    public static void main(String[] args) throws IOException {
        Game.createGamesArrayFromRepository();
        Event.createArrayFromRepo();
        FavouritesService.resetRepo();
        Menu menu = new Menu();
        menu.menuStart();
    }
}
