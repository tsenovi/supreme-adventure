package journal;

import javax.swing.text.html.FormSubmitEvent;

public class Test {

    public static void main(String[] args) {

        School pmg = new School("Akad. Ivan Tsenov");

        Student currentStudent = pmg.getCourse("2025").getSchoolClass("A").getStudent("Petar Petrov");

        Subject subject = new Subject("History");

        Grade grade = new Grade(6, currentStudent, subject);

        currentStudent.getGrades().add(grade);
        currentStudent.

    }
}
