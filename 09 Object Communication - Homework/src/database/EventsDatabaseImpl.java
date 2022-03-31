package database;

import event.DateParser;
import event.Event;

import java.util.Date;

public class EventsDatabaseImpl implements EventsDatabase {

    private final Event[] events;
    private int eventCount;

    public EventsDatabaseImpl() {
        this.events = new Event[100];
        this.eventCount = 0;
    }

    @Override
    public void addEvent(String eventName, String startDate, String startTime,
                         String endDate, String endTime, String comment) {
        Date start = DateParser.parse(startDate, startTime);
        Date end = DateParser.parse(endDate, endTime);
        Event event = new Event(eventName, start, end, comment);
        events[eventCount] = event;
        eventCount++;
    }

    @Override
    public Event[] getEventsByDate(Date date) {
        int dailyEventsCount = 0;
        for (int i = 0; i < eventCount; i++) {
            if(events[i].getStart().getDate() == date.getDate()){
                dailyEventsCount++;
            }
        }

        Event[] dailyEvents = new Event[dailyEventsCount];
        int index = 0;
        for (int i = 0; i < eventCount; i++) {
            if(events[i].getStart().getDate() == date.getDate()){
                dailyEvents[index] = events[i];
                index++;
            }
        }

        return dailyEvents;
    }

    @Override
    public Event getEventByName(String eventName) {
        for (int i = 0; i < eventCount; i++) {
            if(events[i].getName().equalsIgnoreCase(eventName)){
                return events[i];
            }
        }

        return null;
    }

    @Override
    public boolean setEventTime(String eventName, String startTime, String endTime) {
        Event currentEvent = getEventByName(eventName);
        Date newStartTime = DateParser.parse(startTime);
        Date newEndTime = DateParser.parse(endTime);

        if(newStartTime != null && newEndTime != null){
            currentEvent.getStart().setHours(newStartTime.getHours());
            currentEvent.getStart().setMinutes(newStartTime.getMinutes());
            currentEvent.getEnd().setHours(newEndTime.getHours());
            currentEvent.getEnd().setMinutes(newEndTime.getMinutes());
            return true;
        }

        return false;
    }
}
