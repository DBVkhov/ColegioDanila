package Repository;

import Repository.Entities.Classrooms;
import Repository.Entities.Users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static Config.ConfigH2DB.getConnection;

public class ClassroomsRepository {

    private final String CLASSROOMS = "CLASSROOMS";

    public Classrooms getClassroomByIDFromDB(int id){


        try {
            String query = "SELECT * FROM "+ CLASSROOMS +" WHERE id = ?";
            PreparedStatement statement = getConnection().prepareStatement(query);

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            Classrooms classrooms = null;

            while (resultSet.next()) {

                int iD = resultSet.getInt("ID");
                String pass = resultSet.getString("PASSWORD");
                classrooms = new Classrooms();

            }
            return classrooms;

        } catch (SQLException e) {
            System.out.println("ERROR in ClassroomRepository in getByID");
            throw new RuntimeException(e);
        }



    }

    public List<Classrooms> getAllClassroomsFromDB(){
        try {
            List<Classrooms> classroom = null;
            String query = "SELECT * FROM "+ CLASSROOMS;
            PreparedStatement statement = getConnection().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                int iD = resultSet.getInt("ID");
                String pass = resultSet.getString("PASSWORD");
                classroom.add(new Classrooms(iD, pass));

            }
            return classroom;

        } catch (SQLException e) {
            System.out.println("ERROR in ClassroomRepository in getAllClassroomFromDB");
            throw new RuntimeException(e);
        }
    }

    public void setNewClassroomInDB(Classrooms classroom){

        try {
            String query = "INSERT INTO "+ CLASSROOMS +" (id, password) VALUES (?, ?)";
            PreparedStatement statement = getConnection().prepareStatement(query);

            statement.setInt(1, classroom.getId());
            statement.setString(2, classroom.getPassword());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR in ClassroomRepository in setNewClassroomDB");
            throw new RuntimeException(e);
        }

    }

    public void modifyPasswordClassroomInDB(int id, String password){
        String qr = "UPDATE"+ CLASSROOMS +"SET password = ? WHERE id = ?";
        try{
            PreparedStatement statement = getConnection().prepareStatement(qr);
            statement.setString(1, password);
            statement.setInt(2, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR in ClassroomRepository in modifyPasswordClassroom");
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
