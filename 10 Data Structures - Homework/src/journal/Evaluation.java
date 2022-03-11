package journal;

public class Evaluation {

    private double value;
    private Student student;
    private Subject subject;

    public Evaluation(double value, Student student, Subject subject) {
        this.value = value;
        this.student = student;
        this.subject = subject;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
