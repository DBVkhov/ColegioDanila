package Service;

import DTOs.ClassroomsDTO;
import DTOs.StudentsDTO;
import DTOs.TeachersDTO;

import java.io.IOException;
import java.sql.SQLException;

public interface AdminsService {
    void addTeacherDTOToDB(TeachersDTO teacher);
    void addClassroomDTOToDB(ClassroomsDTO classroom);
    void addStudentDTOToDB(StudentsDTO student);
    void changeTeacherDTOToDB(TeachersDTO teacher) throws IOException, SQLException;
    StudentsDTO searchStudentDTOByID(int id) throws SQLException;
}
