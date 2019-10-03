package Exceptions;

import java.util.HashSet;
import java.util.Set;

public class UniversityBelSut {
    public static void main(String args[]) {
        try {
            Set<Student> firstCourseCivilEngineering = new HashSet<>();
            Set<Student> firstCourseMachineMechanics = new HashSet<>();
            Set<Student> firstCourseMilitaryEngineer = new HashSet<>();
            Set<Student> firstCourseArchitect = new HashSet<>();

            Set<Group> buildingGroups = new HashSet<>();
            Set<Group> militaryGroups = new HashSet<>();
            Set<Group> machineGroups = new HashSet<>();

            Student anna = new Student("Anna");
            Student vendy = new Student("Vendy");
            Student olga = new Student("Olga");
            Student alina = new Student("Alina");
            Student maxim = new Student("Maxim");
            Student igor = new Student("Igor");
            Student oleg = new Student("Oleg");
            Student vitaly = new Student("Vitaly");

            anna.setAssessment("Math", 6);
            anna.setAssessment("Russian", 7);
            anna.setAssessment("Math", 8);
            vendy.setAssessment("English", 8);
            olga.setAssessment("Math", 5);
            alina.setAssessment("English", 6);
            alina.setAssessment("Russian", 9);
            vendy.setAssessment("Russian", 6);
            maxim.setAssessment("Technology", 9);
            maxim.setAssessment("English", 5);
            igor.setAssessment("Russian", 7);
            oleg.setAssessment("Russian", 8);
            oleg.setAssessment("Technology", 5);
            vitaly.setAssessment("Technology", 10);


            firstCourseCivilEngineering.add(anna);
            firstCourseCivilEngineering.add(vendy);
            firstCourseCivilEngineering.add(alina);
            firstCourseMilitaryEngineer.add(oleg);
            firstCourseMachineMechanics.add(igor);
            firstCourseArchitect.add(vitaly);

            Group civilEngineeringGroup = new Group("CivilEngineeringGroup", firstCourseCivilEngineering);

            Group militaryEngineerGroup = new Group("MilitaryEngineerGroup", firstCourseCivilEngineering);
            Group machineMechanicsGroup = new Group("MachineMechanicsGroup", firstCourseCivilEngineering);
            Group architectGroup = new Group("ArchitectGroup", firstCourseCivilEngineering);

            buildingGroups.add(civilEngineeringGroup);
            militaryGroups.add(militaryEngineerGroup);
            machineGroups.add(machineMechanicsGroup);
            civilEngineeringGroup.addStudentsInGroup(maxim);


            Faculty buildingFaculty = new Faculty("BuildingFaculty", buildingGroups);
            buildingFaculty.addGroupsInFaculty(architectGroup);

            Faculty militaryFaculty = new Faculty("MilitaryFaculty", militaryGroups);
            Faculty machineFaculty = new Faculty("MachineFaculty", machineGroups);

            Set<Faculty> belSUTFaculty = new HashSet<>();
            belSUTFaculty.add(buildingFaculty);

            University belSUT = new University("BelSUT", belSUTFaculty);

            belSUT.addFacultyInUniversity(militaryFaculty);
            belSUT.addFacultyInUniversity(machineFaculty);
            belSUT.addFacultyInUniversity(machineFaculty);

            calculateAverage(belSUT, "BuildingFaculty", "CivilEngineeringGroup", "Russian");

        } catch (DefaultSubjectException e) {
            e.getMessage();
        } catch (InvalidRatingException e) {
            e.getMessage();
        } catch (EmptyGroupException e) {
            e.getMessage();

        } catch (EmptyFacultyException e) {
            e.getMessage();
        } catch (EmptyUniversityException e) {
            e.getMessage();


        }
    }
        private static Double calculateAverage (University university, String nameOfFaculty, String nameOFGroup, String
        subject){
            Group group = university.getFacultyByName(nameOfFaculty).getGroupByName(nameOFGroup);
            return group.getAverageAssessmentForSubject(subject);
        }
    }




