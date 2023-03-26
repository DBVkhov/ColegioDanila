package Repository;
import static Config.ConfigH2DB.getConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import Repository.Entities.Subjects;
import Repository.Entities.Teachers;

public class TeachersRepository {

    private final String TEACHERS = "TEACHERS";

    private final SubjectsRepository subjectsRepository = new SubjectsRepository();

    public Teachers getTeacherByIDFromDB(int id) throws SQLException {

        String qr = "SELECT * FROM " + TEACHERS + " WHERE id = ?";
        PreparedStatement statement = getConnection().prepareStatement(qr);

        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        Teachers teacher = null;

        while(resultSet.next()){
            int iD = resultSet.getInt("id");
            String dni = resultSet.getString("dni");
            String name = resultSet.getString("name");
            Date age = resultSet.getDate("age");
            Subjects subject = subjectsRepository.getSubjectByID(resultSet.getInt("idsub"));
            teacher = new Teachers(iD, dni, name, age, subject);
        }

        return teacher;
    }

}
