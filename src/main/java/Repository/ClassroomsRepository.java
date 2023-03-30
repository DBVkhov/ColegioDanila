package Repository;

import Repository.Entities.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static Config.ConfigH2DB.getConnection;

public class ClassroomsRepository {

    private final String CLASSROOMS = "CLASSROOMS";

    private final SubjectsRepository subjectsRepository = new SubjectsRepository();
    private final TeachersRepository teachersRepository = new TeachersRepository();

    private final StudentsInClassroomsRepository studentsInClassroomsRepository = new StudentsInClassroomsRepository();

    public Classrooms getClassroomByIDFromDB(int id){


        try {
            String query = "SELECT * FROM "+ CLASSROOMS +" WHERE id = ?";
            PreparedStatement statement = getConnection().prepareStatement(query);

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            Classrooms classrooms = null;
            List<StudentsInClassroom> liststudent;

            while (resultSet.next()) {

                int iD = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int course = resultSet.getInt("course");
                Subjects subject = subjectsRepository.getSubjectByID(resultSet.getInt("idsub"));
                Teachers teacher = teachersRepository.getTeacherByIDFromDB(resultSet.getInt("idteach"));
                int qstudents = resultSet.getInt("qstudents");
                liststudent = studentsInClassroomsRepository.getStudentsClassroomsByClassroomIDFromDB(resultSet.getInt("idcr"));
                classrooms = new Classrooms(iD, name, course, subject, teacher, liststudent, qstudents);
            }
            return classrooms;

        } catch (SQLException e) {
            System.out.println("ERROR in ClassroomRepository in getByID");
            throw new RuntimeException(e);
        }

    }

    public List<Classrooms> getAllClassroomsFromDB(){
        try {
            String query = "SELECT * FROM "+ CLASSROOMS;
            PreparedStatement statement = getConnection().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            Classrooms classroom;
            List<Classrooms> classrooms = null;
            List<StudentsInClassroom> liststudent;

            while (resultSet.next()) {

                int iD = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int course = resultSet.getInt("course");
                Subjects subject = subjectsRepository.getSubjectByID(resultSet.getInt("idsub"));
                Teachers teacher = teachersRepository.getTeacherByIDFromDB(resultSet.getInt("idteach"));
                int qstudents = resultSet.getInt("qstudents");
                liststudent = studentsInClassroomsRepository.getStudentsClassroomsByClassroomIDFromDB(resultSet.getInt("idcr"));
                classroom = new Classrooms(iD, name, course, subject, teacher, liststudent, qstudents);
                classrooms.add(classroom);
            }
            return classrooms;

        } catch (SQLException e) {
            System.out.println("ERROR in ClassroomRepository in getAllClassroomFromDB");
            throw new RuntimeException(e);
        }
    }

    public void setNewClassroomInDB(Classrooms classroom){

        try {
            String query = "INSERT INTO "+ CLASSROOMS +" (name, course, idsub, idteach, qstudents) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = getConnection().prepareStatement(query);

            statement.setString(1, classroom.getName());
            statement.setInt(2, classroom.getCourse());
            statement.setInt(3, classroom.getSubject().getId());
            statement.setInt(4, classroom.getTeacher().getId());
            statement.setInt(5, classroom.getQuantityOfStudents());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR in ClassroomRepository in setNewClassroomDB");
            throw new RuntimeException(e);
        }

    }

    public void modifyClassroomInDB(int id, String name, int course, int idsubject, int idteacher, int quantityofstudents){
        String qr = "UPDATE "+ CLASSROOMS +" SET name = ?, course = ?, idsub = ?, idteach = ?, qstudents = ?  WHERE id = ?";
        try{
            PreparedStatement statement = getConnection().prepareStatement(qr);
            statement.setString(1, name);
            statement.setInt(2, course);
            statement.setInt(3, idsubject);
            statement.setInt(4, idteacher);
            statement.setInt(5, quantityofstudents);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR in ClassroomRepository in modifyClassroom");
        }
    }

    public void deleteClassroomInDB(int id){
        try {

            String query = "DELETE FROM "+ CLASSROOMS + " WHERE  id = ?";
            PreparedStatement statement = getConnection().prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR in ClassroomRepository in deleteClassroom");
        }
    }

}
