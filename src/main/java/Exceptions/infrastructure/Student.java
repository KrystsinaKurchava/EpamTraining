package exceptions.infrastructure;

import exceptions.customExceptions.DefaultSubjectException;
import exceptions.customExceptions.InvalidRatingException;

import java.util.LinkedHashMap;
import java.util.Map;

public class Student {
    private String nameOfStudent;
    private Map<String, Integer> assessment;

    public Student(String setNameOfStudent) {
        this.nameOfStudent = setNameOfStudent;
        assessment = new LinkedHashMap<>();

    }

    public void setAssessment(String name, Integer ball) throws DefaultSubjectException, InvalidRatingException {
        if (name == null) throw new DefaultSubjectException("Студенту необходимо указать предмет");
        if (ball < 0 || ball > 10) throw new InvalidRatingException("Оценка должна быть в пределах от 1 до 10");
        assessment.put(name, ball);
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




