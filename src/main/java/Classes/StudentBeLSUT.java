package Classes;

public class StudentBeLSUT {
    public static void main(String[] args) {
        Student student1 = new Student("Алина", "Малинова", "Андреевна", "12.13.2000", "Гомель", "124577", "ПГС", "3", "ПК");
        Student student2 = new Student("Сергей", "Хойников", "Сергеевич", "12.13.1997", "Минск", "346784", "МФ", "2", "МФ");
        Student student3 = new Student("Артем", "Артемов", "Артомович", "12.13.1996", "Брест", "234687", "ВТФ", "4", "ВТ");
        Student student4 = new Student("Иван", "Иванов", "Иванович", "12.13.1993", "Гомель", "3257844", "ПГС", "5", "ПК");
        Student student5 = new Student("Олег", "Сидоров", "Олегович", "12.13.1999", "Могилев", "987643", "ГЭФ", "3", "ГБ");
        Student student6 = new Student("Алексей", "Антонченко", "Олегович", "12.13.1998", "Светлогорск", "456775", "ВТФ", "4", "ВТ");
        Student student7 = new Student("Карина", "Новикова", "Николаевна", "12.13.1997", "Речица", "4246783", "ГЭф", "4", "ГЭ");
        Student student8 = new Student("Кристина", "Рябина", "Адреевна", "12.13.1996", "Жлобин", "234689", "ПГС", "5", "ПС");


        StudentArray StudentBeLSUT = new StudentArray(8);
        StudentBeLSUT.addStudentInList(student1, 0);
        StudentBeLSUT.addStudentInList(student2, 1);
        StudentBeLSUT.addStudentInList(student3, 2);
        StudentBeLSUT.addStudentInList(student4, 3);
        StudentBeLSUT.addStudentInList(student5, 4);
        StudentBeLSUT.addStudentInList(student6, 5);
        StudentBeLSUT.addStudentInList(student7, 6);
        StudentBeLSUT.addStudentInList(student8, 7);

        final String pgsFacultyName = "ПГС";
        final String gefFacultyName = "ГЭФ";
        final String thirdCourseNumber = "3";
        final String selectionDateOfBirth = "1998";
        final String mfGroupName = "МФ";

        StudentBeLSUT.chooseStudentOneFaculty(pgsFacultyName);
        StudentBeLSUT.chooseStudentAllFacultyAndCourse(gefFacultyName, thirdCourseNumber);
        StudentBeLSUT.chooseStudentDateOfBirth(selectionDateOfBirth);
        StudentBeLSUT.chooseStudentOneGroup(mfGroupName);

    }
}


