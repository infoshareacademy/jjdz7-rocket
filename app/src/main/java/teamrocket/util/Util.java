package teamrocket.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Util {

    private Util() {
    }

    public static void writeToFile(Path path, byte[] content) throws IOException {
        StandardOpenOption writeOption =
                Files.exists(path) ?
                        StandardOpenOption.APPEND :
                        StandardOpenOption.CREATE_NEW;
        Files.write(path, content, writeOption);
    }

    public static void writeToFileWtihTruncate(Path path, byte[] content) throws IOException {
        StandardOpenOption writeOption =
                Files.exists(path) ?
                        StandardOpenOption.TRUNCATE_EXISTING :
                        StandardOpenOption.CREATE_NEW;
        Files.write(path, content, writeOption);
    }


    public static List<String> readFileContent(Path path) throws IOException {
        return Files.readAllLines(path);
    }

    public static String readInputWithMessage(String message) {
        System.out.println(message);
        return readUserInput();
    }

    public static Integer readInputIntegerWithMessage(String message) {
        System.out.println(message);
        return readUserInputInteger();
    }

    public static LocalDate readInputDateWithMessage(String message) {
        try {
            System.out.println(message);
            return LocalDate.parse(readUserInput());
        } catch (DateTimeParseException e) {
            System.out.println("Zły format daty. Proszę wpisz poprawny RRRR-MM-DD ");
            return LocalDate.parse(readUserInput());
        }
    }

    public static LocalTime readInputTimeWithMessage(String message) {
        try {
            System.out.println(message);
            return LocalTime.parse(readUserInput());
        } catch (DateTimeParseException e) {
            System.out.println("Zły format czasu. Proszę wpisz poprawny GG:MM ");
            return LocalTime.parse(readUserInput());
        }
    }

    public static String readUserInput() {
        return new Scanner(System.in).nextLine();
    }

    public static int readUserInputInteger() {
        try {
            return new Scanner(System.in).nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Nieprawidłowa wartość. Podaj liczbę całkowitą: ");
            return new Scanner(System.in).nextInt();
        }
    }

    public static String addSpaces(int i, String str) {
        StringBuilder str1 = new StringBuilder();
        for (int j = 0; j < i - str.length(); j++) {
            str1.append(" ");
        }
        str = str + str1;
        return str;
    }

    public static void printHeading() {
        System.out.println("ID Gry |" +
                " Nazwa gry                                                                " +
                "| Liczba graczy " +
                "| Typ gry ");
    }
}
