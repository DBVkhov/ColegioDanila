package Repository;

import Repository.Entities.Subjects;
import static Config.ConfigH2DB.getConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SubjectsRepository {
    private String SUBJECTS = "SUBJECTS";

    public Subjects getSubjectByID(int id) throws SQLException {
        String qr = "SELECT * FROM " + SUBJECTS + " WHERE id = ?";
        PreparedStatement statement = getConnection().prepareStatement(qr);
        statement.setInt(1, id);
        ResultSet resultSet = statement.getResultSet();

        Subjects subject = null;

        while (resultSet.next()){

            int iD = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int course = resultSet.getInt("course");
            String description = resultSet.getString("description");

            subject = new Subjects(iD, name, course, description);
        }

        return subject;

    }
}
