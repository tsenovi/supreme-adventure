package journal;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String studentName;
    private List<Grade> grades;

    public Student(String studentName) {
        this.studentName = studentName;
        this.grades = new ArrayList<Grade>();
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }
}
