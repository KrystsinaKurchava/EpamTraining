package Classes;

public class Student {
    private static int nextId = 0;
    private String name;
    private String surname;
    private String patronymic;
    private String dateOfBirth;
    private String address;
    private String number;
    private String faculty;
    private String course;
    private String group;

    public Student() {
        this.name = "";
        this.surname = "";
        this.patronymic = "";
        this.dateOfBirth = "";
        this.address = "";
        this.number = "";
        this.faculty = "";
        this.course = "";
        this.group = "";
    }

    public Student(String name, String surname, String patronymic, String dateOfBirth, String address, String number, String faculty, String course, String group) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.number = number;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }

    private int id = nextId++;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getCourse() {
        return course;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return name +
                " " + surname +
                " " + patronymic +
                ",  " + dateOfBirth +
                ", город проживания " + address +
                ", номер телефона " + number +
                ", факультет " + faculty +
                ", курс " + course +
                ", группа " + group +
                ", номер " + id;

    }
}




