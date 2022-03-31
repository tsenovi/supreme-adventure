package database;

import event.Event;

import java.util.Date;

public interface EventsDatabase
{

    void addEvent(String eventName, String startDate, String startTime,
                  String endDate, String endTime, String comment);

    Event[] getEventsByDate(Date date);

    Event getEventByName(String desiredEventName);

    boolean setEventTime(String eventName, String startTime, String endTime);
}
