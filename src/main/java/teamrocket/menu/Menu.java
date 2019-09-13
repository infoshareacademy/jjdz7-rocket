package teamrocket.menu;

import teamrocket.App;

import javax.imageio.stream.ImageInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
        public Menu() throws IOException {
            start ();

            teamrocket.App myGeek = new App ("Geek");
            System.out.println("### Command Options ### ");
            System.out.println ( "1: # search for user #" );
            System.out.println ( "2: ##### GAME    #####" );
            System.out.println ( "3: ##### EVENT   #####" );
            System.out.println ( "4: ##### Register ####" );
            System.out.println ( "5: ##### Display #####");
            System.out.println ( "q: ##### Quit    #####");
            Scanner scan = new Scanner(System.in);
            String choice = scan.nextLine();
            do {
                switch (choice) {
                    case "1": {
                        Scanner scanner = new Scanner ( "Git" );
                        System.out.println ( "1: Search tools by Name" );
                        System.out.println ( "2: Search for player by name" );
                        System.out.println ( "3: Search for player by ID" );
                        {
                            {

                                if ("1".equals ( scan )) {
                                    System.out.println ( "Name" );
                                    String word1 = scan.nextLine ();
                                    myGeek.repeat ();
                                } else if ("2".equals ( scan )) {
                                    System.out.println ( "surname" );
                                    String e = scan.nextLine ();
                                    myGeek.getName ();
                                } else if ("3".equals ( scan )) {
                                    System.out.println ( "ID player" );
                                    String d = scan.nextLine ();
                                    myGeek.repeat ();
                                }
                            }
                            while (choice != "end") ;
                        }
                    }

                    case "2":
                        System.out.println ( "Game" );
                        String word1 = scan.nextLine();
                        System.out.println ( "game type" );
                        int numberOfTimes = scan.nextInt();
                        myGeek.repeat(word1, numberOfTimes);
                        break;
                    case "3":
                        System.out.println ( "..." );
                        break;
                    case "4":
                        System.out.println ( "ID Gracza" );
                        String word2 = scan.nextLine();
                        myGeek.isPalindrome ();
                        break;
                    case "5":
                        System.out.println("### Command Options ### ");
                        System.out.println ( "1: # search for user #" );
                        System.out.println ( "2: ##### GAME    #####" );
                        System.out.println ( "3: ##### EVENT   #####" );
                        System.out.println ( "4: ##### Register ####");
                        System.out.println ( "5: ##### Display #####");
                        System.out.println ( "q: ##### Quit    #####");
                        break;
                    default:

                }
            }
            while (choice != "q");
        }

    public void start() throws IOException {

    }
}

