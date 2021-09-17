package functions;

import java.io.BufferedReader;
import java.io.IOException;


public class TaskReader {

    public static String read(BufferedReader reader) {
        try{
            return reader.readLine();
        } catch (IOException ignored) {
            return "";
        }
    }
}
