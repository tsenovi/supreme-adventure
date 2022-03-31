package eDiary.school;

import java.util.ArrayList;
import java.util.List;

public class School {

    private final String schoolName;
    private final List<Course> courses;

    public School(String schoolName) {
        this.schoolName = schoolName;
        this.courses = new ArrayList<>();
        createInitialCourses();
    }

    public String getSchoolName() {
        return schoolName;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public double getAvgScore() {
        double totalScore = 0;
        for (Course course : courses) {
            totalScore = totalScore + course.getAvgScore();
        }

        if (courses.size() == 0){
            return 0.0;
        }

        return totalScore / courses.size();
    }

    private void createInitialCourses() {
        courses.add(new Course("2025"));
        courses.add(new Course("2026"));
    }

    @Override
    public String toString(){
        return schoolName;
    }
}
