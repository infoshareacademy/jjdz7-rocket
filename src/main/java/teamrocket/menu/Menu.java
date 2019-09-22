package teamrocket.menu;

import teamrocket.App;
import teamrocket.model.Event;

import teamrocket.model.EventService;
import teamrocket.model.Game;
import teamrocket.util.Util;

import javax.imageio.stream.ImageInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Menu {

        public static void menuStart() throws IOException {
            System.out.println (" ### Command Options ### ");
            System.out.println ( "1: # search for user #"  );
            System.out.println ( "2: ##### GAME     #####" );
            System.out.println ( "3: ##### ADD Game #####" );
            System.out.println ( "4: ##### EVENT    #####" );
            System.out.println ( "5: ##### Place    #####" );
            System.out.println ( "6: ##### Display  #####" );
            System.out.println ( "q: ##### Quit     #####" );
            String choice = Util.readUserInput();
            do {
                switch (Util.readUserInputInteger()) {
                    case 1: {
                        switch(choice){
                            case "1":
                                System.out.println ( "1: Search for player by Name" );
                            Util.readUserInput();
                                    break;
                            case "2":
                                System.out.println( "2: Search for player by ID" );
                                Util.readUserInput();
                                break;
                        }

/*                        {
                            {
                            if ("1".equals ( scan )) {
                                System.out.println ( "Name" );
                                int word1 = scan.nextInt ();
                            }

                            else if ("2".equals ( scan )) {
                                    System.out.println ( "ID player" );
                                    int numberOfTime = scan.nextInt ();

                                }
                            }
                            while (choice != "end") ;
                        }*/
                    }
                    case 2: {
                        Game.createArrayFromRepo();
                        System.out.println ("1: Show all games " );
                        System.out.println ("2: Search for a game by name " );
                        System.out.println("3: Filter Game by Type ");
                        System.out.println("4: Filter Game by Number of Players ");

                        switch(Util.readUserInputInteger()){
                            case 1: Game.showAllGames();
                            case 2: Game.searchGameByName();
                            case 3: Game.filterByGameType();
                            case 4: Game.filterByNumberOfPlayers();
                        }

                        System.out.println ( "q: Exit" );
                        while (choice != "q");
                        break;
                    }
                    case 3:
                        break;
                    case 4:
                        Event.createArrayFromRepo();
                        System.out.println ("1: Show all games " );
                        System.out.println ("2: Search for a game by name " );
                        System.out.println("3: Filter Game by Type ");
                        System.out.println("4: Filter Game by Number of Players ");

                        switch(Util.readUserInputInteger()){
                            case 1: Event.showAllEvents();
                        }
                        Event.showAllEvents();
                        Event.filterEventByDate() ;
                        Event.filterEventsByType();
                        //dodawanie wydarzenia
                        EventService eventService = new EventService();
                        eventService.addEvent(eventService.getEventFromConsole(), eventService.getEventID());
                        break;
                    case 5:
                        System.out.println ( "Place" );
                        Util.readUserInput();

                        break;
                    case 6:
                        System.out.println ("### Command Options ### "  );
                        System.out.println ( "1: # search for user #"   );
                        System.out.println ( "2: ##### GAME     #####"  );
                        System.out.println ( "3: ##### ADD Game #####"  );
                        System.out.println ( "4: ##### EVENT    #####"  );
                        System.out.println ( "5: ##### Place    #####"  );
                        System.out.println ( "6: ##### Display  #####"  );
                        System.out.println ( "q: ##### Quit     #####"  );
                        Util.readUserInputInteger();
                        break;
                }

            }while (choice != "q");

                System.out.println ( "Koniec" );

        }
}

