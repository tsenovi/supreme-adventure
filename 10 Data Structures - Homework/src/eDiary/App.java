package eDiary;

import eDiary.inputoutput.InputOutputImpl;
import eDiary.school.SchoolDatabaseImpl;
import eDiary.system.DiaryController;

public class App {

    public static void main(String[] args) {

        new DiaryController(
                new SchoolDatabaseImpl(),
                new InputOutputImpl()
        ).start();
    }
}
