package exceptions.infrastructure;

import exceptions.customExceptions.EmptyFacultyException;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class Faculty {
    private String nameOfFaculty;
    private Set<Group> groupsInFaculty;

    public String getNameOfFaculty() {
        return nameOfFaculty;
    }

    public Faculty(String nameOfFaculty, Collection<Group> groupsInFaculty) throws EmptyFacultyException {
        if (groupsInFaculty == null || groupsInFaculty.size() == 0)
            throw new EmptyFacultyException("В факультете должен быть хотя бы одна группа");
        this.groupsInFaculty = new LinkedHashSet(groupsInFaculty);
        this.nameOfFaculty = nameOfFaculty;
    }

    public void addGroupsInFaculty(Group group) {
        groupsInFaculty.add(group);
    }

    public Group getGroupByName(String name) {
        for (Group group : groupsInFaculty) {
            if (group.getNameOfGroup().equals(name)) {
                return group;
            }
        }
        return null;
    }

    public Double getAverageAssessmentByFaculty (String subject) {
        double summaryOfAveragesByFaculty = 0;
        for(Group group : groupsInFaculty)
        {
            summaryOfAveragesByFaculty = summaryOfAveragesByFaculty + group.getAverageAssessmentForSubject(subject);
        }

        return summaryOfAveragesByFaculty / groupsInFaculty.size();
    }
}
