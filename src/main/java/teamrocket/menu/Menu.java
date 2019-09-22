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

        public static void menuStart() throws IOException{
            System.out.println(" ### Command Options ### ");
            System.out.println("1: ##### GAME     #####");
            System.out.println("2: ##### EVENT    #####");
            System.out.println("0: ##### Quit     #####");
            int choice = Util.readUserInputInteger();
            switch (choice) {
                case 1: {
                    Game.createArrayFromRepo();
                    System.out.println("1: Show all games ");
                    System.out.println("2: Search for a game by name ");
                    System.out.println("3: Filter Game by Type ");
                    System.out.println("4: Filter Game by Number of Players ");
                    System.out.println("9: Go back to Main Menu");
                    System.out.println("0: Exit");

                    switch (Util.readUserInputInteger()) {
                        case 1:
                            Game.showAllGames();
                            break;
                        case 2:
                            Game.searchGameByName();
                            break;
                        case 3:
                            Game.filterByGameType();
                            break;
                        case 4:
                            Game.filterByNumberOfPlayers();
                            break;
                        case 9:
                            menuStart();
                        case 0:
                            break;
                    }
                    break;

                }
                case 2:
                    Event.createArrayFromRepo();
                    System.out.println("1: Show all Events ");
                    System.out.println("2: Filter Event by Type ");
                    System.out.println("3: Filter Event by Date ");
                    System.out.println("4: Add new Event ");
                    System.out.println("9: Go back to Main Menu");
                    System.out.println("0: Exit");

                    switch (Util.readUserInputInteger()) {
                        case 1:
                            Event.showAllEvents();
                            break;
                        case 2:
                            Event.filterEventsByType();
                            break;
                        case 3:
                            Event.filterEventByDate();
                            break;
                        case 4:
                            EventService eventService = new EventService();
                            eventService.addEvent(eventService.getEventFromConsole(), eventService.getEventID());
                            break;
                        case 9:
                            menuStart();
                        case 0:
                            break;
                    }
                    break;
                case 0:
                    break;
            }
        }
}

