import calendar.Application;
import com.ConsoleManagerImpl;
import event.PersonalCalendarImpl;

public class Main {

    public static void main(String[] args) {
        new Application(
                new ConsoleManagerImpl(),
                new PersonalCalendarImpl()
        ).initialize();
    }
}
