package teamrocket.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

public class Util {

    private Util() {
    }

    public static void writeToFile(Path path, byte[] content) throws IOException {
        StandardOpenOption writeOption =
                Files.exists ( path ) ?
                        StandardOpenOption.APPEND :
                        StandardOpenOption.CREATE_NEW;
        Files.write ( path, content, writeOption );
    }

    public static List<String> readFileContent(Path path) throws IOException {
        return Files.readAllLines( path );
    }

    public static String readInputWithMessage(String message) {
        System.out.println ( message );
        return readUserInput ();
    }

    public static String readUserInput() {
        return new Scanner ( System.in ).nextLine ();
    }

    public static String addSpaces(int i, String str){
        StringBuilder str1 = new StringBuilder();
        for(int j=0;j<i-str.length();j++)
        { str1.append(" "); }
        str = str + str1;
        return str;
    }

}
