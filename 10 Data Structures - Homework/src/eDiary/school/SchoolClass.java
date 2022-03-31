package eDiary.school;

import eDiary.evaluation.Student;
import eDiary.evaluation.Subject;

import java.util.ArrayList;
import java.util.List;

public class SchoolClass {

    private final String classID;
    private final List<Student> students;
    private final List<Subject> subjects;

    public SchoolClass(String classID) {
        this.classID = classID;
        this.students = new ArrayList<>();
        this.subjects = new ArrayList<>();
        createInitiateStudents();
        createInitiateSubjects();
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public double getAvgScore() {
        double totalScore = 0;
        for (Student student : students) {
            totalScore = totalScore + student.getAvgScore();
        }

        if (students.size() == 0){
            return 0.0;
        }

        return totalScore / students.size();
    }

    @Override
    public String toString(){
        return classID;
    }

    private void createInitiateStudents() {
        students.add(new Student("Petar Petrov"));
        students.add(new Student("Angel Angelov"));
    }

    private void createInitiateSubjects() {
        subjects.add(new Subject("Mathematics"));
        subjects.add(new Subject("Science"));
        subjects.add(new Subject("Technology"));
        subjects.add(new Subject("English"));
    }
}
