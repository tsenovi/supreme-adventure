package eDiary.evaluation;

public class Subject {

    private final String subjectName;

    public Subject(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public String toString(){
        return subjectName;
    }
}
