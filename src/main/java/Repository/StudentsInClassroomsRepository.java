package Repository;

import Repository.Entities.Classrooms;
import Repository.Entities.StudentInClassroom;
import Repository.Entities.Students;
import Repository.Entities.Subjects;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static Config.ConfigH2DB.getConnection;

public class StudentsInClassroomsRepository {

    String STUDENTSINCLASSROOMS = "STUDENTSINCLASSROOMS";

    private final StudentsRepository studentsRepository = new StudentsRepository();
    private final ClassroomsRepository classroomsRepository = new ClassroomsRepository();
    private final SubjectsRepository subjectsRepository = new SubjectsRepository();

    public List<StudentInClassroom> getStudentsClassroomsByStudentIDFromDB(int id) throws SQLException {
        String qr = "SELECT * FROM " + STUDENTSINCLASSROOMS + " WHERE idstud = ?";
        PreparedStatement statement = getConnection().prepareStatement(qr);

        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        StudentInClassroom studentInClassroom = null;
        List<StudentInClassroom> studentInClassrooms = null;

        while(resultSet.next()){
            int iD = resultSet.getInt("id");
            Students student = studentsRepository.getStudentByIDFromDB(resultSet.getInt("idstud"));
            Classrooms classroom = classroomsRepository.getClassroomByIDFromDB(resultSet.getInt("idcr"));
            Subjects subject = subjectsRepository.getSubjectByID(resultSet.getInt("idsub"));
            studentInClassroom = new StudentInClassroom(iD, student, classroom, subject);
            studentInClassrooms.add(studentInClassroom);
        }

        return studentInClassrooms;

    }

    public List<StudentInClassroom> getStudentsClassroomsByClassroomIDFromDB(int id) throws SQLException {
        String qr = "SELECT * FROM " + STUDENTSINCLASSROOMS + " WHERE idcr = ?";
        PreparedStatement statement = getConnection().prepareStatement(qr);

        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        StudentInClassroom studentInClassroom = null;
        List<StudentInClassroom> studentInClassrooms = null;

        while(resultSet.next()){
            int iD = resultSet.getInt("id");
            Students student = studentsRepository.getStudentByIDFromDB(resultSet.getInt("idstud"));
            Classrooms classroom = classroomsRepository.getClassroomByIDFromDB(resultSet.getInt("idcr"));
            Subjects subject = subjectsRepository.getSubjectByID(resultSet.getInt("idsub"));
            studentInClassroom = new StudentInClassroom(iD, student, classroom, subject);
            studentInClassrooms.add(studentInClassroom);
        }

        return studentInClassrooms;

    }

}
