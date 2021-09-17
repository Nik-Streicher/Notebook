package functions.notebook;

import functions.Corrector;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Note {

    private final boolean priority;
    private final String currentDate;
    private final String task;
    private final String expirationDate;
    private int id;

    public Note(boolean priority, String task, String expirationDate, int id) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

        this.priority = priority;
        this.currentDate = dateFormat.format(new Date());
        this.task = task;
        this.expirationDate = expirationDate;
        this.id = id;
    }

    public static Note createFromString(String input, int id) {

        String expirationDate = Corrector.formatDate(input.substring(input.lastIndexOf('"') + 1).replace(" ", ""));

        if (!Corrector.checkTask(input) || expirationDate == null) return null;

        boolean priority = input.charAt(0) == '*';
        String task = input.substring(input.indexOf('"') + 1, input.lastIndexOf('"'));

        return new Note(priority, task, expirationDate, id);
    }

    // realize Comparable

    public void setId(int id) {
        this.id = id;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public String getTask() {
        return task;
    }

    public int getId() {
        return id;
    }

    public boolean isPriority() {
        return priority;
    }
}
