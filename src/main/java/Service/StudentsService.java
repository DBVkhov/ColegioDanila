package Service;

import DTOs.StudentsDTO;

import java.sql.SQLException;

public interface StudentsService {
    void gradesBySubject(StudentsDTO student) throws SQLException;
}
