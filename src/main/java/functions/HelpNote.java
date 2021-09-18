package functions;

public class HelpNote {

    public static void WriteHelp() {
        System.out.println("""

                to view notes -> /show
                to view priority notes -> /Pshow
                to write a new note -> /add + note
                to remove the last note -> /removeLast\s
                to remove a note by id -> /remove + id
                to display the given documentation -> /help
                to close -> /close

                Correct note format -> "note text" 20.12.2020
                To mark a note as priority add '*' for example -> *"note text" 20.12.2020
                """);
    }
}
