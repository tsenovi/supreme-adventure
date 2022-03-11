package journal;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private String courseYear;
    private List<SchoolClass> schoolClasses;
    private double courseScore;

    public Course(String courseYear) {
        this.courseYear = courseYear;
        this.schoolClasses = new ArrayList<SchoolClass>();
        this.courseScore = calculateScore();
        createInitialClasses();
    }

    public String getCourseYear() {
        return courseYear;
    }

    public void setCourseYear(String courseYear) {
        this.courseYear = courseYear;
    }

    public List<SchoolClass> getSchoolClasses() {
        return schoolClasses;
    }

    public void setSchoolClasses(List<SchoolClass> schoolClasses) {
        this.schoolClasses = schoolClasses;
    }

    public SchoolClass getSchoolClass(String id) {
        for (SchoolClass schoolClass : schoolClasses) {
            if (schoolClass.getClassID().equalsIgnoreCase(id))
                return schoolClass;
        }

        return null;
    }

    public double getCourseScore() {
        return courseScore;
    }

    private double calculateScore() {
        double totalScore = 0;
        for (SchoolClass schoolClass : schoolClasses) {
            totalScore = totalScore + schoolClass.getSchoolClassScore();
        }

        return totalScore;
    }

    private void createInitialClasses() {
        schoolClasses.add(new SchoolClass("A"));
        schoolClasses.add(new SchoolClass("B"));
        schoolClasses.add(new SchoolClass("C"));
    }
}
