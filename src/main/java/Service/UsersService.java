package Service;

import DTOs.UsersDTO;

import java.sql.SQLException;
import java.util.List;

public interface UsersService {

    void login(int id, String password) throws SQLException;

}
