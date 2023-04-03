package Service;

import DTOs.StudentsDTO;
import DTOs.TeachersDTO;

import java.sql.SQLException;

public interface TeachersService {
    void studentInfo(StudentsDTO student, TeachersDTO teacher) throws SQLException;
    void listOfStudentsInClassroom();
    void setGrade(StudentsDTO student);
    void addStudentToClassroom(StudentsDTO student);

}
