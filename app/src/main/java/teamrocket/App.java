package teamrocket;

import teamrocket.menu.Menu;
import java.io.IOException;

public class App {

    public App(String geek) throws IOException {

    }

    public static void main(String[] args ) throws IOException {
       Menu menu = new Menu();
       menu.menuStart();
    }
}
