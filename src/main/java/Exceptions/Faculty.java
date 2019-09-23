package Exceptions;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class Faculty {
    String nameOfFaculty;
    private Set<Group> groupsInFaculty;

    public String getNameOfFaculty() {
        return nameOfFaculty;
    }

    public void setNameOfFaculty(String nameOfFaculty) {
        this.nameOfFaculty = nameOfFaculty;
    }

    public Faculty(String nameOfFaculty, Collection<Group> groupsInFaculty) throws IllegalArgumentException{
            if (groupsInFaculty == null || groupsInFaculty.size() == 0)
                throw new IllegalArgumentException("Университет не можент быть без быть без факультета");
            this.groupsInFaculty = new LinkedHashSet(groupsInFaculty);
            this.nameOfFaculty = nameOfFaculty;
    }
    public void addGroupsInFaculty(Group group) {
            groupsInFaculty.add(group);
          }

    public void removeGroupsInFaculty(Group group) throws IllegalArgumentException{
            if (groupsInFaculty.size() == 1 && groupsInFaculty.contains(group))
                throw new IllegalArgumentException("Невозомжно удалить последний факультет.");
            groupsInFaculty.remove(group);
    }

    public Group getGroupByName (String name) {
        for(Group group : groupsInFaculty)
        {
            if(group.getNameOfGroup().equals(name)){
                return group;
            }
        }

        return null;
    }

    public Double getAverageAssessmentByFaculty () {
        double summaryOfAveragesByFaculty = 0;
        for(Group group : groupsInFaculty)
        {
            summaryOfAveragesByFaculty = summaryOfAveragesByFaculty + group.getAverageAssessmentByGroup();
        }

        return summaryOfAveragesByFaculty / groupsInFaculty.size();
    }
}
