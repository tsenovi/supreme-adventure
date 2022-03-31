import calendar.Application;
import com.ConsoleManagerImpl;
import database.EventsDatabaseImpl;

public class Main {

    public static void main(String[] args) {
        new Application(
                new ConsoleManagerImpl(),
                new EventsDatabaseImpl()
        ).initialize();
    }
}
