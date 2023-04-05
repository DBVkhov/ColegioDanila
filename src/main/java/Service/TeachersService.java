package Service;

import DTOs.ClassroomsDTO;
import DTOs.StudentsDTO;
import DTOs.TeachersDTO;

import java.io.IOException;
import java.sql.SQLException;

public interface TeachersService {
    void studentInfo(StudentsDTO student, TeachersDTO teacher) throws SQLException;
    void listOfStudentsInClassroom(ClassroomsDTO classroom);
    void setGrade(StudentsDTO student, TeachersDTO teacher) throws IOException;
    void addStudentToClassroom(StudentsDTO student, ClassroomsDTO classroom);

}
