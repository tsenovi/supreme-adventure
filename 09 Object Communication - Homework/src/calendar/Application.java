package calendar;

import com.ConsoleManager;
import event.DateParser;
import event.Event;
import database.EventsDatabase;

import java.util.Date;

public class Application {

    private final ConsoleManager consoleManager;
    private final EventsDatabase personalCalendar;


    public Application(ConsoleManager consoleManager, EventsDatabase personalCalendar) {
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
                case 5 -> searchForFreeEventTimeRange();
                //TODO option 5
            }
        }
    }

    private void searchForFreeEventTimeRange() {
        consoleManager.show("Event start date " + DateParser.DATE_FORMAT);
        String startDate = consoleManager.getTextInput();
        consoleManager.show("Event time duration " + DateParser.TIME_FORMAT);
        String eventDuration = consoleManager.getTextInput();
    }

    private void changeEventTime() {
        consoleManager.show("Enter event name: ");
        String eventName = consoleManager.getTextInput();
        while (true) {
            consoleManager.show("Event start time " + DateParser.TIME_FORMAT);
            String startTime = consoleManager.getTextInput();
            consoleManager.show("Event end time " + DateParser.TIME_FORMAT);
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
        consoleManager.show("Enter event details");
        consoleManager.show("Event name:");
        String name = consoleManager.getTextInput();
        consoleManager.show("Event start date " + DateParser.DATE_FORMAT);
        String startDate = consoleManager.getTextInput();
        consoleManager.show("Event start time " + DateParser.TIME_FORMAT);
        String startTime = consoleManager.getTextInput();
        consoleManager.show("Event end date " + DateParser.DATE_FORMAT);
        String endDate = consoleManager.getTextInput();
        consoleManager.show("Event end time " + DateParser.TIME_FORMAT);
        String endTime = consoleManager.getTextInput();
        consoleManager.show("Event comment:");
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
