package eDiary.school;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private final String courseYear;
    private final List<SchoolClass> schoolClasses;

    public Course(String courseYear) {
        this.courseYear = courseYear;
        this.schoolClasses = new ArrayList<>();
        createInitialClasses();
    }

    public String getCourseYear() {
        return courseYear;
    }

    public List<SchoolClass> getSchoolClasses() {
        return schoolClasses;
    }

    public double getAvgScore() {
        double totalScore = 0;
        for (SchoolClass schoolClass : schoolClasses) {
            totalScore = totalScore + schoolClass.getAvgScore();
        }

        if (schoolClasses.size() == 0) {
            return 0.0;
        }

        return totalScore / schoolClasses.size();
    }

    @Override
    public String toString() {
        return courseYear;
    }

    private void createInitialClasses() {
        schoolClasses.add(new SchoolClass("A"));
        schoolClasses.add(new SchoolClass("B"));
    }
}
