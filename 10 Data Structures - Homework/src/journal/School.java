package journal;

import java.util.ArrayList;
import java.util.List;

public class School {

    private String schoolName;
    private List<Course> courses;

    public School(String schoolName) {
        this.schoolName = schoolName;
        this.courses = new ArrayList<Course>();
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

    private void createInitialCourses() {
        courses.add(new Course("2025"));
        courses.add(new Course("2026"));
        courses.add(new Course("2027"));
        courses.add(new Course("2028"));
    }
}
