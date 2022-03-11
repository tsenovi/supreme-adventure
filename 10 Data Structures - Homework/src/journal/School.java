package journal;

import java.util.ArrayList;
import java.util.List;

public class School {

    private String schoolName;
    private List<Course> courses;
    private double schoolScore;

    public School(String schoolName) {
        this.schoolName = schoolName;
        this.courses = new ArrayList<Course>();
        this.schoolScore = calculateScore();
        createInitialCourses();
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public Course getCourse(String year){
        for (Course course : courses) {
            if(course.getCourseYear().equalsIgnoreCase(year))
                return course;
        }
        return null;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    private double calculateScore() {
        double totalScore = 0;
        for (Course course : courses) {
            totalScore = totalScore + course.getCourseScore();
        }

        return totalScore;
    }

    private void createInitialCourses() {
        courses.add(new Course("2025"));
        courses.add(new Course("2026"));
        courses.add(new Course("2027"));
        courses.add(new Course("2028"));
    }
}
