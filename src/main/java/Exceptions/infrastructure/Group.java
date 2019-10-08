package exceptions.infrastructure;
import exceptions.customExceptions.EmptyGroupException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Group {

    String nameOfGroup;
    private Set<Student> studentsInGroup;

    public String getNameOfGroup() {
        return nameOfGroup;
    }

    public Group(String nameOFGroup, Collection<Student> studentsInGroup) throws EmptyGroupException {
            if (studentsInGroup.size() == 0) throw new EmptyGroupException("Группа пуста");
            this.nameOfGroup = nameOFGroup;
            this.studentsInGroup = new HashSet<Student>(studentsInGroup);
    }

    public void addStudentsInGroup(Student student){
            studentsInGroup.add(student);
    }

    public Double getAverageAssessmentForSubject (String subject) {
        double summaryOfAveragesByGroup = 0;
        double subjectsCount = 0;
        for(Student student : studentsInGroup)
        {
            Integer assessment = student.getSubjectAssessment(subject);
            if(assessment != null){
                subjectsCount++;
                summaryOfAveragesByGroup = summaryOfAveragesByGroup + assessment;
            }
        }

        return summaryOfAveragesByGroup / subjectsCount;
    }
}