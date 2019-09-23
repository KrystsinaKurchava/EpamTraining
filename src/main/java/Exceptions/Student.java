package Exceptions;
import java.util.LinkedHashMap;
import java.util.Map;

public class Student {
    String nameOfStudent;
    Map<String, Integer> assessment;

    public String getNameOfStudent() {
        return nameOfStudent;
    }

    public void setNameOfStudent(String nameOfStudent) {
        this.nameOfStudent = nameOfStudent;
    }

    public Student(String setNameOfStudent) {
        this.nameOfStudent = setNameOfStudent;
        assessment = new LinkedHashMap<>();

    }

    public void setAssessment(String name, Integer ball) throws IllegalArgumentException {
        if (name == null) throw new IllegalArgumentException("Студенту необходимо указать предмет");
        if (ball < 0 || ball > 10) throw new IllegalArgumentException("Оценка должна быть в пределах от 1 до 10");
        assessment.put(name, ball);
    }

    public void removeAssessment(String name, Integer ball) {
        assessment.remove(name, ball);
    }

    public double averageAssessment() {
        double summary = 0;
        for (Integer value : assessment.values()) {
            summary += value;
        }

        return summary / assessment.size();
    }

    public Integer getSubjectAssessment(String subject) {
        if (assessment.containsKey(subject))
            return assessment.get(subject);
        else
            return null;
    }
}




