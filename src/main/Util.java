package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

public class Util {

    public static String readUserInput() {
        return new Scanner(System.in).nextLine();
    }

    //Ta metoda może być wykorzystywana do zapisywania do pliku
    public static void writeToFile(Path path, byte[] content) throws IOException {
        StandardOpenOption writeOption =
                Files.exists(path) ?
                        StandardOpenOption.APPEND :
                        StandardOpenOption.CREATE_NEW;
        Files.write(path, content, writeOption);
    }

    //Ta metoda przyda sie do odczytywania dnaych z pliku
    public static List<String> readFileContent(Path path) throws IOException {
        return Files.readAllLines(path);
    }
}
