package functions;


import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Corrector {

    public static boolean checkTask(String task) {
        return countChars(task, '"') == 2;
    }

    public static String formatDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

        try {
            return date.equals("") ? "Unknown" : dateFormat.format(dateFormat.parse(date));

        } catch (ParseException ignored) {
            System.err.println("Wrong task format");
            return null;
        }
    }


    // count specific chars in entered String
    public static int countChars(String input, char sign) {
        int counter = 0;
        for (char x : input.toCharArray())
            if (x == sign) counter++;

        return counter;
    }
}
