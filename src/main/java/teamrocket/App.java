package teamrocket;

import teamrocket.model.Game;
import teamrocket.menu.Menu;
import java.io.IOException;

public class App {

    public App(String geek) throws IOException {
}

    public static void main(String[] args ) throws IOException {
//        new Menu ().start ();
        Game game = new Game();
        game.createArrayFromRepo();
/*       TODO: Metody do wrzucenia do menu
        game.showAllGames();
        game.searchGameByName();
        game.filterByGameType();
        game.filterByNumberOfPlayers();*/

    }

    public void repeat() {
    //TODO

    }

    public void getName() {

    }

    public void repeat(String word1, int numberOfTimes) {
    }

    public void sum(int num1, int num2) {
    }

    public void isPalindrome() {
    }
}
