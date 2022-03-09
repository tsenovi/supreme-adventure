package journal;

import java.util.ArrayList;
import java.util.List;

public class SchoolClass {

    private String classID;
    private List<Student> students;
    private List<Subject> subjects;

    public SchoolClass(String classID) {
        this.classID = classID;
        this.students = new ArrayList<Student>();
        this.subjects = new ArrayList<Subject>();
        createInitiateStudents();
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

    private void createInitiateStudents() {
        students.add(new Student("Petar Petrov"));
        students.add(new Student("Angel Angelov"));
        students.add(new Student("Todor Todorov"));
        students.add(new Student("Simeon Simeonov"));
    }
}
