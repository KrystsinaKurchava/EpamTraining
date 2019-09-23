package Exceptions;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Group {

    String nameOfGroup;
    private Set<Student> studentsInGroup;

    public String getNameOfGroup() {
        return nameOfGroup;
    }

    public void setNameOfGroup(String nameOfGroup) {
        this.nameOfGroup = nameOfGroup;
    }

    public Group(String nameOFGroup, Collection<Student> studentsInGroup) throws IllegalArgumentException {
            if (studentsInGroup.size() == 0) throw new IllegalArgumentException("Группа пуста");
            this.nameOfGroup = nameOFGroup;
            this.studentsInGroup = new HashSet<Student>(studentsInGroup);
    }

    public void addStudentsInGroup(Student student){
            studentsInGroup.add(student);
    }

    public void removeStudentsInGroup(Student student) throws IllegalArgumentException {
            if (studentsInGroup.size() == 1 && studentsInGroup.contains(student))
                throw new IllegalArgumentException("Невозомжон удалить последнего студента. Группа не может быть пустой");
            studentsInGroup.remove(student);
    }

    public Student getStudentByName (String name) {
        for(Student student : studentsInGroup)
        {
            if(student.getNameOfStudent().equals(name)){
                return student;
            }
        }

        return null;
    }

    public Double getAverageAssessmentByGroup () {
        double summaryOfAveragesByGroup = 0;
        for(Student student : studentsInGroup)
        {
                return summaryOfAveragesByGroup = summaryOfAveragesByGroup + student.averageAssessment();
        }

        return summaryOfAveragesByGroup / studentsInGroup.size();
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