package journal;

import java.util.ArrayList;
import java.util.List;

public class SchoolClass {

    private String classID;
    private List<Student> students;
    private List<Subject> subjects;
    private double schoolClassScore;

    public SchoolClass(String classID) {
        this.classID = classID;
        this.students = new ArrayList<Student>();
        this.subjects = new ArrayList<Subject>();
        this.schoolClassScore = calculateScore();
        createInitiateStudents();
        createInitiateSubjects();
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getStudent(String name) {
        for (Student student : students) {
            if (student.getStudentName().equalsIgnoreCase(name))
                return student;
        }

        return null;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public Subject getSubject(String name) {
        for (Subject subject : subjects) {
            if (subject.getSubjectName().equalsIgnoreCase(name))
                return subject;
        }

        return null;
    }

    public double getSchoolClassScore() {
        return schoolClassScore;
    }

    private double calculateScore() {
        double totalScore = 0;
        for (Student student : students) {
            totalScore = totalScore + student.getStudentScore();
        }

        return totalScore;
    }

    private void createInitiateStudents() {
        students.add(new Student("Petar Petrov"));
        students.add(new Student("Angel Angelov"));
        students.add(new Student("Todor Todorov"));
        students.add(new Student("Simeon Simeonov"));
    }

    private void createInitiateSubjects() {
        subjects.add(new Subject("Mathematics"));
        subjects.add(new Subject("Science"));
        subjects.add(new Subject("Technology"));
        subjects.add(new Subject("English"));
    }
}
