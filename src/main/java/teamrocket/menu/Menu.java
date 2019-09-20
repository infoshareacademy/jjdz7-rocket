package teamrocket.menu;

import teamrocket.App;
import teamrocket.model.Event;
import teamrocket.model.FavouriteGames;
import teamrocket.model.Game;

import javax.imageio.stream.ImageInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
        public Menu() throws IOException {
            start ();

            App myGeek = new App ("Geek");
            System.out.println (" ### Command Options ### ");
            System.out.println ( "1: # search for user #"  );
            System.out.println ( "2: ##### GAME     #####" );
            System.out.println ( "3: ##### ADD Game #####" );
            System.out.println ( "4: ##### EVENT    #####" );
            System.out.println ( "5: ##### Place    #####" );
            System.out.println ( "6: ##### Display  #####" );
            System.out.println ( "q: ##### Quit     #####" );
            Scanner scan = new Scanner(System.in);
            String choice = scan.nextLine();
            do {
                switch (choice) {
                    case "1": {
                        System.out.println ( "1: Search for player by Name" );
                        scan.nextLine ();
                        System.out.println ( "2: Search for player by ID" );
                        int numberOfTimes = scan.nextInt();
                        myGeek.repeat(numberOfTimes);
                        {
                            {
                            if ("1".equals ( scan )) {
                                System.out.println ( "Name" );
                                int word1 = scan.nextInt ();
                                myGeek.repeat ( word1 );
                            }

                            else if ("2".equals ( scan )) {
                                    System.out.println ( "ID player" );
                                    int numberOfTime = scan.nextInt ();
                                    myGeek.repeat ( numberOfTime );

                                }
                            }
                            while (choice != "end") ;
                        }
                    }
                    case "2": {
                        System.out.println ( "1: Search for a game by name" );
                        System.out.println ( "2: Show all games" );
                        Game game = new Game();
                        Game.createArrayFromRepo();
                        game.showAllGames();
                        game.searchGameByName();
                        game.filterByGameType();
                        game.filterByNumberOfPlayers();
                        scan.nextLine ();
                        int Times = scan.nextInt();
                        myGeek.repeat(Times);

                        System.out.println ( "q: Exit" );
                        while (choice != "q");

                        break;

                    }
                    case "3":
                        FavouriteGames.addGame (
                                FavouriteGames.getUserFromConsole ()
                        );

                        break;
                    case "4":
                        System.out.println ( "Event" );
                        scan.nextLine ();
                        Event.showAllEvents();
                        Event.filterEventByDate() ;
                        Event.filterEventsByType();
                        break;
                    case "5":
                        System.out.println ( "Place" );
                        scan.nextLine ();
                        myGeek.isPalindrome ();

                        break;
                    case "6":
                        System.out.println ("### Command Options ### "  );
                        System.out.println ( "1: # search for user #"   );
                        System.out.println ( "2: ##### GAME     #####"  );
                        System.out.println ( "3: ##### ADD Game #####"  );
                        System.out.println ( "4: ##### EVENT    #####"  );
                        System.out.println ( "5: ##### Place    #####"  );
                        System.out.println ( "6: ##### Display  #####"  );
                        System.out.println ( "q: ##### Quit     #####"  );
                        scan.nextLine ();
                        break;
                    default:


                }

            }
            while (choice != "q");
        }
    public void start() throws IOException {

    }
    private int getUserInput() {
        System.out.print("Your choice: ");
        return Integer.parseInt(Game.readGameInput ());
    }

    private void printBadChoice(){
        System.out.println("Zly wybor!!");
    }

    private void list(Game[] users){
        for (Game user : users) {
            System.out.println ( user );
        }
        }
}

