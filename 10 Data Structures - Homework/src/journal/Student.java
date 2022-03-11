package journal;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String studentName;
    private List<Evaluation> evaluations;
    private double studentScore;

    public Student(String studentName) {
        this.studentName = studentName;
        this.evaluations = new ArrayList<Evaluation>();
        this.studentScore = calculateScore();
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<Evaluation> getGrades() {
        return evaluations;
    }

    public void setGrades(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

    public double getStudentScore() {
        return studentScore;
    }

    private double calculateScore() {
        double totalScore = 0;
        for (Evaluation evaluation : evaluations) {
            totalScore = totalScore + evaluation.getValue();
        }

        return totalScore;
    }
}
