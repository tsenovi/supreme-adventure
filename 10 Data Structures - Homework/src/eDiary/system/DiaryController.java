package eDiary.system;

import eDiary.evaluation.Evaluation;
import eDiary.evaluation.Student;
import eDiary.evaluation.Subject;
import eDiary.inputoutput.InputOutput;
import eDiary.school.*;

public class DiaryController {

    private final SchoolDatabase database;
    private final InputOutput inputOutput;

    public DiaryController(SchoolDatabase database, InputOutput inputOutput) {
        this.database = database;
        this.inputOutput = inputOutput;
    }

    public void start() {
        while (true) {
            inputOutput.show(getSystemOptions());
            int userChoice = inputOutput.getDecimalInput();
            switch (userChoice) {
                case 1 -> runStudentManagementProcess();
                case 2 -> viewStatistics();
            }
        }
    }

    private void viewStatistics() {
        int userChoice = -1;
        while (userChoice != 0) {
            inputOutput.show(getStatisticsOptions());
            userChoice = inputOutput.getDecimalInput();
            switch (userChoice) {
                case 1 -> viewSchoolPerformance();
                case 2 -> viewCoursePerformance();
            }
        }
    }

    private void viewCoursePerformance() {
        School selectedSchool = getSchoolByInputIndex();
        Course selectedCourse = getCourseByInputIndex(selectedSchool);
        inputOutput.show("Course: " + selectedCourse.getCourseYear() + "\nAvg Score: " + selectedCourse.getAvgScore());
    }

    private void viewSchoolPerformance() {
        School selectedSchool = getSchoolByInputIndex();
        inputOutput.show("School: " + selectedSchool.getSchoolName() + "\nAvg Score: " + selectedSchool.getAvgScore());
    }

    private void runStudentManagementProcess() {
        School selectedSchool = getSchoolByInputIndex();
        Course selectedCourse = getCourseByInputIndex(selectedSchool);
        SchoolClass selectedClass = getClassByInputIndex(selectedCourse);
        Student selectedStudent = getStudentByInputIndex(selectedClass);

        int userChoice = -1;
        while (userChoice != 0) {
            inputOutput.show(selectedStudent.toString());
            inputOutput.show(getStudentManagementOptions());
            inputOutput.show("Select option: ");
            userChoice = inputOutput.getDecimalInput();
            switch (userChoice) {
                case 1 -> addStudentEvaluationProcess(selectedClass, selectedStudent);
                case 2 -> viewStudentPerformance(selectedStudent);
            }
        }
    }

    private void addStudentEvaluationProcess(SchoolClass schoolClass, Student student) {
        inputOutput.printList(schoolClass.getSubjects());
        inputOutput.show("Select subject: ");
        Subject subject = schoolClass.getSubjects().get(inputOutput.getListIndexInput(schoolClass.getSubjects()));
        inputOutput.show("Input evaluation value: ");
        int selectedValue = inputOutput.getDecimalInput();
        Evaluation evaluation = new Evaluation(selectedValue, student, subject);
        student.getEvaluations().add(evaluation);
    }

    private void viewStudentPerformance(Student student) {
        if (student.getEvaluations().isEmpty()) {
            inputOutput.show("No available evaluations!");
        } else {
            inputOutput.printList(student.getEvaluations());
        }
    }

    private Student getStudentByInputIndex(SchoolClass selectedClass) {
        inputOutput.printList(selectedClass.getStudents());
        inputOutput.show("Select student: ");
        int index = inputOutput.getListIndexInput(selectedClass.getStudents());
        return selectedClass.getStudents().get(index);
    }

    private SchoolClass getClassByInputIndex(Course selectedCourse) {
        inputOutput.printList(selectedCourse.getSchoolClasses());
        inputOutput.show("Select class: ");
        int index = inputOutput.getListIndexInput(selectedCourse.getSchoolClasses());
        return selectedCourse.getSchoolClasses().get(index);
    }

    private Course getCourseByInputIndex(School selectedSchool) {
        inputOutput.printList(selectedSchool.getCourses());
        inputOutput.show("Select course: ");
        int index = inputOutput.getListIndexInput(selectedSchool.getCourses());
        return selectedSchool.getCourses().get(index);
    }

    private School getSchoolByInputIndex() {
        inputOutput.printList(database.getSchools());
        inputOutput.show("Select school: ");
        int index = inputOutput.getListIndexInput(database.getSchools());
        return database.getSchools().get(index);
    }

    private String getSystemOptions() {
        return """
                        Main menu
                1. Manage student performance
                2. Statistics""";
    }

    private String getStudentManagementOptions() {
        return """
                0. Return to main menu
                1. Add evaluation
                2. View performance""";
    }

    private String getStatisticsOptions() {
        return """
                0. Return to main menu
                1. School performance
                2. Course performance""";
    }
}
