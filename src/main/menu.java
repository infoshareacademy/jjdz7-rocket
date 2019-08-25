package main;

import Geek.Geek;

import java.util.Scanner;

public interface menu {
    public static void main(String args[]){
        Geek myGeek = new Geek("Geek");
        System.out.println("### Command Options ### ");
        System.out.println ( "1: ###### GAME #####" );
        System.out.println ( "2: search for user" );
        System.out.println ( "3: ##### EVENT #####" );
        System.out.println ( "4: ...");
        System.out.println ( "5: Register" );
        System.out.println ( "6: Display");
        System.out.println ( "q: Quit");
        Scanner scan = new Scanner(System.in);
        String choice = scan.nextLine();
        do {
            switch (choice) {
                case "2": {
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

                case "1":
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
                    System.out.println("...");
                    int num1 = scan.nextInt();
                    System.out.println("...");
                    int num2 = scan.nextInt();
                    myGeek.sum(num1, num2);
                    break;
                case "5":
                    System.out.println ( "ID Gracza" );
                    String word2 = scan.nextLine();
                    myGeek.isPalindrome ();
                    break;
                case "6":
                    System.out.println("### Command Options ### ");
                    System.out.println ( "1: ###### GAME #####" );
                    System.out.println ( "2: search for user" );
                    System.out.println ( "3: ##### EVENT #####" );
                    System.out.println ( "4: ...");
                    System.out.println ( "5: ...");
                    System.out.println ( "6: Display");
                    System.out.println ( "q: Quit");
                    break;
                default:

            }
        }
        while (choice != "q");
    }
}

