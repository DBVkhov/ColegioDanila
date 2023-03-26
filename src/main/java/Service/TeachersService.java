package Service;

import DTOs.StudentsDTO;

public interface TeachersService {
    void studentInfo(StudentsDTO student);
    void listOfStudentsInClassroom();
    void setGrade(StudentsDTO student);
    void addStudentToClassroom(StudentsDTO student);

}
