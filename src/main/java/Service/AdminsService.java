package Service;

import DTOs.ClassroomsDTO;
import DTOs.StudentsDTO;
import DTOs.TeachersDTO;

public interface AdminsService {
    void addTeacherDTOToDB(TeachersDTO teacher);
    void addClassroomDTOToDB(ClassroomsDTO classroom);
    void addStudentDTOToDB(StudentsDTO student);
    void changeTeacherDTOToDB(TeachersDTO teacher);
    StudentsDTO searchStudentDTOByID(int id);
}
