package classes;

import static java.lang.Integer.parseInt;


public class StudentArray {
    private Student[] studentArray;

    public StudentArray(int length) {
        studentArray = new Student[length];
    }

    void addStudentInList(Student newStudent, int index) {
        studentArray[index] = newStudent;
    }

    void chooseStudentOneFaculty(String faculty) {
        System.out.println("Список студентов факультета " + faculty);
        for (Student st : studentArray) {
            if (st.getFaculty().equals(faculty)) {
                System.out.println(st.toString());
            }
        }
    }

    void chooseStudentOneGroup(String group) {
        System.out.println("Список студентов группы " + group);
        for (Student st : studentArray) {
            if (st.getGroup().equals(group)) {
                System.out.println(st.toString());
            }
        }

    }

    void chooseStudentAllFacultyAndCourse(String faculty, String course) {
        System.out.println("Список студентов факультета " + faculty + " " + course + " курса");
        for (Student st : studentArray) {
            if (st.getFaculty().equals(faculty) & st.getCourse().equals(course)) {
                System.out.println(st.toString());
            }
        }
    }

    void chooseStudentDateOfBirth(String year) {
        System.out.println("Список студентов, родившихся после " + year + " года");
        for (Student st : studentArray) {
            if (parseInt(st.getDateOfBirth().substring(6)) > (parseInt(year))) {
                System.out.println(st.toString());
            }
        }
    }
}


