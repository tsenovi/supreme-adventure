package com;

import event.Event;

import java.util.Date;
import java.util.Scanner;

public class ConsoleManagerImpl implements ConsoleManager {

    private final Scanner scanner;

    public ConsoleManagerImpl() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public int getUserChoice() {
        return Integer.parseInt(getTextInput());
    }

    @Override
    public String getTextInput() {
        return scanner.nextLine();
    }

    @Override
    public void show(String text) {
        System.out.println(text);
    }

    @Override
    public Date getDate() {
        return new Date();
    }

    @Override
    public void showDailyEvents(Event[] dailyEvents) {
        for (int i = 0; i < dailyEvents.length; i++) {
            show("Event " + (i + 1) + ": " + dailyEvents[i].toString());
        }
    }
}
