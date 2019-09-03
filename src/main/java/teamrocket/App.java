package teamrocket;

import teamrocket.model.Game;
import java.io.IOException;

public class App 
{
    public static void main( String[] args ) throws IOException {
        Game game = new Game();
        game.showGames();
    }
}
