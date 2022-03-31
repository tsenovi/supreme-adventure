package eDiary.evaluation;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private final String studentName;
    private final List<Evaluation> evaluations;

    public Student(String studentName) {
        this.studentName = studentName;
        this.evaluations = new ArrayList<>();
    }

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }

    public double getAvgScore() {
        double totalScore = 0;
        for (Evaluation evaluation : evaluations) {
            totalScore = totalScore + evaluation.getValue();
        }

        if (evaluations.size() == 0){
            return 0.0;
        }

        return totalScore / evaluations.size();
    }

    @Override
    public String toString(){
        return studentName + " - Score: " + getAvgScore();
    }
}
