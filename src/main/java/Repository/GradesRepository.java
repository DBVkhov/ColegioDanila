package Repository;

import Repository.Entities.Grades;
import Repository.Entities.Students;
import Repository.Entities.Subjects;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import static Config.ConfigH2DB.getConnection;

public class GradesRepository {

    private final String GRADES = "GRADES";

    private final StudentsRepository studentsRepository = new StudentsRepository();

    private final SubjectsRepository subjectsRepository = new SubjectsRepository();

    public List<Grades> getFinalGradesByStudentsIDAndCourse(Students student, int course) throws SQLException {
        List<Grades> grades = null;
        Grades grade = null;

        String qr = "SELECT * FROM " + GRADES + " WHERE idstud = ? AND course = ? AND itsfinal = ?";
        PreparedStatement statement = getConnection().prepareStatement(qr);

        statement.setInt(1, student.getId());
        statement.setInt(2, course);
        statement.setBoolean(3, true);
        ResultSet resultSet = statement.executeQuery();

        while(resultSet.next()){
            int iD = resultSet.getInt("id");
            boolean itsfinal = resultSet.getBoolean("itsfinal");
            Students studenDB = studentsRepository.getStudentByIDFromDB(resultSet.getInt("idstud"));
            Subjects subject = subjectsRepository.getSubjectByID(resultSet.getInt("idsub"));
            int courseDB = resultSet.getInt("course");
            int ngrade = resultSet.getInt("grade");
            String description = resultSet.getString("description");
            grade = new Grades(iD, itsfinal, student, subject, courseDB, ngrade, description);
            grades.add(grade);
        }

        return grades;
    }

    public List<Grades> getGradesByStudentIDAndSubject(Students student, Subjects subject) throws SQLException {
        List<Grades> grades = null;
        Grades grade = null;

        String qr = "SELECT * FROM " + GRADES + " WHERE idstud = ? AND idsub = ?";
        PreparedStatement statement = getConnection().prepareStatement(qr);

        statement.setInt(1, student.getId());
        statement.setInt(2, subject.getId());
        ResultSet resultSet = statement.executeQuery();

        while(resultSet.next()){
            int iD = resultSet.getInt("id");
            boolean itsfinal = resultSet.getBoolean("itsfinal");
            Students studenDB = studentsRepository.getStudentByIDFromDB(resultSet.getInt("idstud"));
            Subjects subjectDB = subjectsRepository.getSubjectByID(resultSet.getInt("idsub"));
            int courseDB = resultSet.getInt("course");
            int ngrade = resultSet.getInt("grade");
            String description = resultSet.getString("description");
            grade = new Grades(iD, itsfinal, student, subjectDB, courseDB, ngrade, description);
            grades.add(grade);
        }


        return grades;
    }

    public void setNewGradeInDB(Grades grade){
        try {
            String query = "INSERT INTO "+ GRADES +" (itsfinal, idstud, idsub, course, grade, description) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = getConnection().prepareStatement(query);

            statement.setBoolean(1, grade.isItsfinal());
            statement.setInt(2, grade.getStudent().getId());
            statement.setInt(3, grade.getSubject().getId());
            statement.setInt(4, grade.getCourse());
            statement.setInt(5, grade.getGrade());
            statement.setString(6, grade.getDescription());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR in GradesRepository in setNewGradeInDB");
            throw new RuntimeException(e);
        }
    }

    public void changeGradeInDB(int id, boolean itsfinal, Students student, Subjects subject, int course, int grade, String description){
        String qr = "UPDATE "+ GRADES +" SET itsfinal = ?, idstud = ?, idsub = ?, course = ?, grade = ?, description = ? WHERE id = ?";
        try{
            PreparedStatement statement = getConnection().prepareStatement(qr);
            statement.setBoolean(1, itsfinal);
            statement.setInt(2, student.getId());
            statement.setInt(3, subject.getId());
            statement.setInt(4, course);
            statement.setInt(5, grade);
            statement.setString(6, description);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR in GradesRepository in changeGradeInDB");
        }
    }

    public void deleteGradeInDB(int id){
        try {

            String query = "DELETE FROM "+ GRADES +" WHERE  id = ?";
            PreparedStatement statement = getConnection().prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR in GradesRepository in deleteGrade");
        }
    }

}
