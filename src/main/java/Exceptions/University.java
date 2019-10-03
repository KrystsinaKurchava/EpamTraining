package Exceptions;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class University {
    String nameOfUniversity;
    private Set<Faculty> facultiesInUniversity;

    public University(String nameOfUniversity, Collection<Faculty> FacultiesInUniversity) throws EmptyUniversityException {
        if (FacultiesInUniversity == null || FacultiesInUniversity.size() == 0)
            throw new EmptyUniversityException("Невозможно существование университета без факультетов");
        this.facultiesInUniversity = new LinkedHashSet(FacultiesInUniversity);
        this.nameOfUniversity = nameOfUniversity;
    }

    public void addFacultyInUniversity(Faculty Faculty) {
        facultiesInUniversity.add(Faculty);
    }

    public Faculty getFacultyByName(String name) {
        for (Faculty faculty : facultiesInUniversity) {
            if (faculty.getNameOfFaculty().equals(name)) {
                return faculty;
            }
        }
        return null;
    }
}
