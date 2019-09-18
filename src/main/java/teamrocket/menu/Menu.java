package teamrocket.menu;

import teamrocket.App;
import teamrocket.model.Event;
import teamrocket.model.Game;

import javax.imageio.stream.ImageInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
        public Menu() throws IOException {
            start ();

            App myGeek = new App ("Geek");
            System.out.println (" ### Command Options ### ");
            System.out.println ( "1: # search for user #" );
            System.out.println ( "2: ##### GAME    #####" );
            System.out.println ( "3: ##### EVENT   #####" );
            System.out.println ( "4: ##### Place   #####" );
            System.out.println ( "5: ##### Display #####");
            System.out.println ( "q: ##### Quit    #####");
            Scanner scan = new Scanner(System.in);
            String choice = scan.nextLine();
            do {
                switch (choice) {
                    case "1": {
                        System.out.println ( "1: Search tools by Name" );
                        System.out.println ( "2: Search for player by ID" );
                        int numberOfTimes = scan.nextInt();
                        myGeek.repeat(numberOfTimes);
                        break;
//                        {
//                           do  {
//                               if ("1".equals ( scan )) {
//                                    System.out.println ( "Name" );
//                                    int word1 = scan.nextInt ();
//                                    myGeek.repeat (word1);
//                                }
//                               {
//                                   if ("2".equals ( scan )) {
//                                       System.out.println ( "ID player" );
//                                        int numberOfTime = scan.nextInt ();
//                                        myGeek.repeat (numberOfTime );
//                                        // nie dziala :/
//                                    }
//                                }
//                           }
//                            while (choice != "end") ;

                    }


                    case "2":
                        System.out.println ( "Game" );


                        Game game = new Game();
                        game.createArrayFromRepo();
//                      TODO: i pyk dodane
                        game.showAllGames();
                        game.searchGameByName();
                        game.filterByGameType();
                        game.filterByNumberOfPlayers();
                        int numberOfTimes = scan.nextInt();
                        myGeek.repeat(numberOfTimes);
                        break;
                    case "3":
                        System.out.println ( "Event" );
                        scan.nextLine ();
                        Event.showAllEvents();
                        Event.filterEventByDate() ;
                        Event.filterEventsByType();
                        break;
                    case "4":
                        System.out.println ( "Place" );
                        scan.nextLine ();
                        myGeek.isPalindrome ();

                        break;
                    case "5":

                        System.out.println (" ### Command Options ### ");
                        System.out.println ( "1: # search for user #" );
                        System.out.println ( "2: ##### GAME    #####" );
                        System.out.println ( "3: ##### EVENT   #####" );
                        System.out.println ( "4: ##### Place   #####");
                        System.out.println ( "5: ##### Display #####");
                        System.out.println ( "q: ##### Quit    #####");
                        scan.nextLine ();
                        break;
                    default:


                }

            }
            while (choice != "q");
        }


    public void start() throws IOException {

    }
}

