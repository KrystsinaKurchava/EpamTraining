package Exceptions;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class University {
    String nameOfUniversity;
    private Set<Faculty> facultiesInUniversity;

    public String getNameOfUniversity() {
        return nameOfUniversity;
    }

    public void setNameOfUniversity(String nameOfUniversity) {
        this.nameOfUniversity = nameOfUniversity;
    }

    public University(String nameOfUniversity, Collection<Faculty> FacultiesInUniversity) throws IllegalArgumentException {
        if (FacultiesInUniversity == null || FacultiesInUniversity.size() == 0)
            throw new IllegalArgumentException("Университет не можент быть без быть без факультета");
        this.facultiesInUniversity = new LinkedHashSet(FacultiesInUniversity);
        this.nameOfUniversity = nameOfUniversity;
    }

    public void addFacultyInUniversity(Faculty Faculty) {
        facultiesInUniversity.add(Faculty);
    }

    public void removeFacultyInUniversity(Faculty faculty) throws IllegalArgumentException {
        if (facultiesInUniversity.size() == 1 && facultiesInUniversity.contains(faculty))
            throw new IllegalArgumentException("Невозомжно удалить последний факультет.");
        facultiesInUniversity.remove(faculty);
    }

    public Faculty getFacultyByName(String name) {
        for (Faculty faculty : facultiesInUniversity) {
            if (faculty.getNameOfFaculty().equals(name)) {
                return faculty;
            }
        }

        return null;
    }

    public Double getAverageAssessmentByUniversity() {
        double summaryOfAveragesByUniversity = 0;
        for (Faculty faculty : facultiesInUniversity) {
            summaryOfAveragesByUniversity = summaryOfAveragesByUniversity + faculty.getAverageAssessmentByFaculty();
        }

        return summaryOfAveragesByUniversity / facultiesInUniversity.size();
    }
}
