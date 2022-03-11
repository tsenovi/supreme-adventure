package journal;

public class App {

    public static void main(String[] args) {

        new JournalController(
                new SchoolDatabase(),
                new InputOutput()
        ).start();
    }
}
