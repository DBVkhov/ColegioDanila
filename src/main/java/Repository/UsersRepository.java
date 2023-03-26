package Repository;

import Repository.Entities.Users;

import java.sql.*;
import java.util.List;

import static Config.ConfigH2DB.getConnection;

public class UsersRepository {

    private final String USERS = "USERS";

    public Users getLoggedUserFromDB(int id, String password){

        Users users = null;

        try {
            String query = "SELECT * FROM "+ USERS +" WHERE id = ? AND password = ?";
            PreparedStatement statement = getConnection().prepareStatement(query);

            statement.setInt(1, id);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                int iD = resultSet.getInt("id");
                String pass = resultSet.getString("password");
                users = new Users(iD, pass);

            }

        } catch (SQLException e) {
            System.out.println("ERROR in UserRepository in getLoggedUser");
            throw new RuntimeException(e);
        }

        return users;
    }

    public Users getUserByIDFromDB(int id){


        try {
            String query = "SELECT * FROM "+ USERS +" WHERE id = ?";
            PreparedStatement statement = getConnection().prepareStatement(query);

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            Users users = null;

            while (resultSet.next()) {

                int iD = resultSet.getInt("ID");
                String pass = resultSet.getString("PASSWORD");
                users = new Users(iD, pass);

            }
            return users;

        } catch (SQLException e) {
            System.out.println("ERROR in UserRepository in getByID");
            throw new RuntimeException(e);
        }



    }

    public List<Users> getAllUsersFromDB(){
        try {
            List<Users> users = null;
            String query = "SELECT * FROM "+ USERS;
            PreparedStatement statement = getConnection().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                int iD = resultSet.getInt("ID");
                String pass = resultSet.getString("PASSWORD");
                users.add(new Users(iD, pass));

            }
            return users;

        } catch (SQLException e) {
            System.out.println("ERROR in UserRepository in getAllUsersFromDB");
            throw new RuntimeException(e);
        }
    }

    public void setNewUserInDB(Users users){

        try {
            String query = "INSERT INTO "+ USERS +" (id, password) VALUES (?, ?)";
            PreparedStatement statement = getConnection().prepareStatement(query);

            statement.setInt(1, users.getId());
            statement.setString(2, users.getPassword());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                int iD = resultSet.getInt("ID");
                String pass = resultSet.getString("PASSWORD");
                users = new Users(iD, pass);

            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR in UserRepository in setNewUserDB");
            throw new RuntimeException(e);
        }

    }

    public void modifyPasswordUserInDB(int id, String password){
        String qr = "UPDATE USERS SET password = ? WHERE id = ?";
        try{
            PreparedStatement statement = getConnection().prepareStatement(qr);
            statement.setString(1, password);
            statement.setInt(2, id);

    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("ERROR in UserRepository in modifyPasswordUser");
    }
    }

    public void deleteUserInDB(int id){
        try {

            String query = "DELETE FROM USERS WHERE  id = ?";
            PreparedStatement statement = getConnection().prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR in UserRepository in deleteUser");
        }
    }
}
