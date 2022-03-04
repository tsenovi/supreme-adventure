package com;

import event.Event;

import java.util.Date;

public interface ConsoleManager {

    Date getDate();

    void showDailyEvents(Event[] dailyEvents);

    int getUserChoice();

    String getTextInput();

    void show(String text);
}
