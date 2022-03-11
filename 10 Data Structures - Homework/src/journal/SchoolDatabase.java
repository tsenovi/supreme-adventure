package journal;

import java.util.ArrayList;
import java.util.List;

public class SchoolDatabase {

    private List<School> schools;

    public SchoolDatabase() {
        this.schools = new ArrayList<>();
        createInitiateSchools();
    }

    public List<School> getSchools() {
        return schools;
    }

    public void setSchools(List<School> schools) {
        this.schools = schools;
    }

    private void createInitiateSchools() {
        schools.add(new School("PMG"));
        schools.add(new School("EG"));
    }
}
