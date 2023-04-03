package Service;

import DTOs.ClassroomsDTO;
import DTOs.StudentsDTO;
import DTOs.TeachersDTO;
import Repository.Entities.Classrooms;
import Repository.Entities.Students;
import Repository.Entities.StudentsInClassroom;
import Repository.Entities.Teachers;
import Repository.StudentsRepository;

import java.sql.SQLException;
import java.util.List;

public class TeachersServiceImplementation implements TeachersService{

    private final StudentsRepository studentsRepository = new StudentsRepository();

    private final StudentsServiceImplementation studentsServiceImplementation = new StudentsServiceImplementation();

    @Override
    public void studentInfo(StudentsDTO student, TeachersDTO teacher) throws SQLException {
        Students studentFromDB = studentsRepository.getStudentByIDFromDB(
                studentsServiceImplementation.changeToStudentEntity(student).getId()
        );
        List<StudentsInClassroom> studentClassrooms = studentFromDB.getClassrooms();
        List<ClassroomsDTO> classrooms = null;
        for(StudentsInClassroom studentClassroom : studentClassrooms){
            Teachers teacherClassroom = studentClassroom.getClassroom().getTeacher();

        }
    }

    @Override
    public void listOfStudentsInClassroom() {

    }

    @Override
    public void setGrade(StudentsDTO student) {

    }

    @Override
    public void addStudentToClassroom(StudentsDTO student) {

    }

    public TeachersDTO changeToTeacherDTO(Teachers teacher){
        TeachersDTO teacherDTO = new TeachersDTO(teacher.getId(), teacher.getName(), teacher.getDni(), teacher.getAge(), teacher.getSubject());
        return teacherDTO;
    }

    public Teachers changeToTeacherEntity(TeachersDTO teacher){
        Teachers teacherEnt = new Teachers(teacher.getId(), teacher.getName(), teacher.getDni(), teacher.getAge(), teacher.getSubject());
        return teacherEnt;
    }

}
