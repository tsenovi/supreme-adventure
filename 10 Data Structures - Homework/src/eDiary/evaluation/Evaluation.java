package eDiary.evaluation;

public class Evaluation {

    private double value;
    private final Student student;
    private final Subject subject;

    public Evaluation(double value, Student student, Subject subject) {
        this.setValue(value);
        this.student = student;
        this.subject = subject;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        if (value > 1 && value < 7) this.value = value;
    }

    public Student getStudent() {
        return student;
    }

    public String toString(){
        return subject + " : " + value;
    }
}
