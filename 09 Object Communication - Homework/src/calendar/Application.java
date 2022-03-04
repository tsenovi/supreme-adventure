package calendar;

import com.ConsoleManager;
import event.DateParser;
import event.Event;
import event.PersonalCalendar;

import java.util.Date;

public class Application {

    private final ConsoleManager consoleManager;
    private final PersonalCalendar personalCalendar;


    public Application(ConsoleManager consoleManager, PersonalCalendar personalCalendar) {
        this.consoleManager = consoleManager;
        this.personalCalendar = personalCalendar;
    }

    public void initialize() {
        while (true) {
            consoleManager.show("Personal Calendar");
            consoleManager.show(previewSystemOptions());
            int userChoice = consoleManager.getUserChoice();
            switch (userChoice) {
                case 1 -> createEvent();
                case 2 -> previewDailyProgram();
                case 3 -> previewEventDetails();
                case 4 -> changeEventTime();
                //TODO option 5 search for free space for event
            }
        }
    }

    private void changeEventTime() {
        consoleManager.show("Enter event name: ");
        String eventName = consoleManager.getTextInput();
        while (true) {
            System.out.println("Event start time " + DateParser.TIME_FORMAT);
            String startTime = consoleManager.getTextInput();
            System.out.println("Event end time " + DateParser.TIME_FORMAT);
            String endTime = consoleManager.getTextInput();

            if (DateParser.isCorrectTime(startTime) &&
                    DateParser.isCorrectTime(endTime)) {
                personalCalendar.setEventTime(eventName, startTime, endTime);
                break;
            } else {
                consoleManager.show("Invalid input!");
            }
        }
    }

    private void previewEventDetails() {
        consoleManager.show("Enter event name: ");
        String desiredEventName = consoleManager.getTextInput();
        Event currentEvent = personalCalendar.getEventByName(desiredEventName);
        if (currentEvent != null) {
            consoleManager.show(currentEvent.toString());
        } else {
            consoleManager.show("No such event exists!");
        }
    }

    private void previewDailyProgram() {
        Date desiredDate = consoleManager.getDate();
        consoleManager.show("Program for today");
        consoleManager.showDailyEvents(personalCalendar.getEventsByDate(desiredDate));
    }

    private void createEvent() {
        System.out.println("Enter event details");
        System.out.println("Event name:");
        String name = consoleManager.getTextInput();
        System.out.println("Event start date " + DateParser.DATE_FORMAT);
        String startDate = consoleManager.getTextInput();
        System.out.println("Event start time " + DateParser.TIME_FORMAT);
        String startTime = consoleManager.getTextInput();
        System.out.println("Event end date " + DateParser.DATE_FORMAT);
        String endDate = consoleManager.getTextInput();
        System.out.println("Event end time " + DateParser.TIME_FORMAT);
        String endTime = consoleManager.getTextInput();
        System.out.println("Event comment:");
        String comment = consoleManager.getTextInput();

        personalCalendar.addEvent(name, startDate, startTime, endDate, endTime, comment);
    }

    private String previewSystemOptions() {
        return """
                1. Create new event
                2. View events for today
                3. View event details
                4. Change event time""";
    }
}
