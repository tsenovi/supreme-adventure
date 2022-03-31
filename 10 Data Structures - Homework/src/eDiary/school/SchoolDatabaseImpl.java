package eDiary.school;

import java.util.ArrayList;
import java.util.List;

public class SchoolDatabaseImpl implements SchoolDatabase {

    private final List<School> schools;

    public SchoolDatabaseImpl() {
        this.schools = new ArrayList<>();
        createInitiateSchools();
    }

    @Override
    public List<School> getSchools() {
        return schools;
    }

    private void createInitiateSchools() {
        schools.add(new School("PMG"));
        schools.add(new School("EG"));
    }
}
