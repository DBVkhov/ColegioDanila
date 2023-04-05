package Service;
import DTOs.*;
import Repository.ClassroomsRepository;
import Repository.Entities.Classrooms;
import Repository.Entities.StudentsInClassroom;
import Repository.GradesRepository;
import Repository.StudentsInClassroomsRepository;
import Repository.StudentsRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

public class TeachersServiceImplementation implements TeachersService{
    private final ChangeClassService changeClassService = new ChangeClassService();
    private final GradesRepository gradesRepository = new GradesRepository();
    private final StudentsInClassroomsRepository studentsInClassroomsRepository = new StudentsInClassroomsRepository();

    @Override
    public void studentInfo(StudentsDTO student, TeachersDTO teacher) throws SQLException {

        System.out.println("name: " + student.getName());
        System.out.println("DNI: " + student.getDni());
        System.out.println("Birthday: " + student.getAge());
        System.out.println("Course: " + student.getCourse());
        for(StudentsInClassroomDTO studentInClassroomDTO : student.getClassrooms()){

            if(studentInClassroomDTO.getClassroom().getTeacher().getId() == teacher.getId()){
                System.out.println("Classroom: " + studentInClassroomDTO.getClassroom().getName());
                System.out.println("Subject: " + studentInClassroomDTO.getClassroom().getSubject().getName());
                System.out.println("Grades: ");
                List<GradesDTO> gradesDTO = changeClassService.changeListOfGradesToDTO(
                        gradesRepository.getGradesByStudentIDAndSubject(changeClassService.changeToStudentEntity(student),
                        changeClassService.changeToSubjectEntity(studentInClassroomDTO.getClassroom().getSubject())
                ));
                for(GradesDTO grade : gradesDTO){
                    System.out.println(grade);
                }
            }
        }
    }

    @Override
    public void listOfStudentsInClassroom(ClassroomsDTO classroom) {
        List<StudentsInClassroomDTO> students = classroom.getStudents();
        System.out.println("Classroom: " + classroom.getName() + "\n");
        for(StudentsInClassroomDTO studentsInClassroomDTO : students){
            System.out.println(studentsInClassroomDTO.getStudent().getName());
            System.out.println(studentsInClassroomDTO.getStudent().getDni());
            System.out.println(studentsInClassroomDTO.getStudent().getId() + "\n");
        }
    }

    @Override
    public void setGrade(StudentsDTO student, TeachersDTO teacher) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("The grade it's final? yes(1)/no(any number):");
        int option = Integer.parseInt(bufferedReader.readLine());
        boolean itsfinal = option == 1;

        System.out.println("Description: ");
        String description = bufferedReader.readLine();

        System.out.println("Grade: ");
        int ngrade = Integer.parseInt(bufferedReader.readLine());

        GradesDTO grade = new GradesDTO(
                itsfinal,
                student,
                teacher.getSubject(),
                teacher.getSubject().getCourse(),
                ngrade,
                description
        );

        gradesRepository.setNewGradeInDB(changeClassService.changeToGradesEntity(grade));
    }

    @Override
    public void addStudentToClassroom(StudentsDTO student, ClassroomsDTO classroom) {
        studentsInClassroomsRepository.setNewStudentInClassroomInDB(
            changeClassService.changeToStudentEntity(student),
            changeClassService.changeToClassroomEntity(classroom)
        );
    }



}
