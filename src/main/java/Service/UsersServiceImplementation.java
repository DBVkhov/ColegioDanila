package Service;

import DTOs.UsersDTO;
import Repository.Entities.Teachers;
import Repository.Entities.Users;
import Repository.StudentsRepository;
import Repository.TeachersRepository;
import Repository.UsersRepository;

import java.sql.SQLException;
import java.util.List;

public class UsersServiceImplementation implements UsersService {

    private final UsersRepository usersRepository = new UsersRepository();

    private final TeachersRepository teachersRepository = new TeachersRepository();
    private final StudentsRepository studentsRepository = new StudentsRepository();

    @Override
    public void login(int id, String password) throws SQLException {

        final Users loggedUser = usersRepository.getLoggedUserFromDB(id, password);

        if(loggedUser != null){
            if(teachersRepository.getAllTeachersFromDB().stream().anyMatch(teacher -> teacher.getId()==loggedUser.getId())){};
            if(studentsRepository.getAllStudentsFromDB().stream().anyMatch(student -> student.getId()==loggedUser.getId())){};
            if(usersRepository.itsAdmin(loggedUser)){};
        }

    }

    public UsersDTO changeToUserDTO(Users users){return new UsersDTO(users.getId(), users.getPassword());}

    public Users changeToUserEntity(UsersDTO user){return new Users(user.getId(), user.getPassword());}

    public void createUserDTOInDB(UsersDTO user){
        usersRepository.setNewUserInDB(changeToUserEntity(user));
    }

    public void changePasswordOfUserDTO(UsersDTO user){
        Users usersEntity = changeToUserEntity(user);
        usersRepository.modifyPasswordUserInDB(usersEntity.getId(), usersEntity.getPassword());
    }

    public void deleteUserDTOFromDB(UsersDTO user){
        usersRepository.deleteUserInDB(changeToUserEntity(user).getId());
    }

    public UsersDTO getUserDTOFromDBByID(int id){
        return changeToUserDTO(usersRepository.getUserByIDFromDB(id));
    }

    public List<UsersDTO> usersList() {
        List<UsersDTO> usersDTO = null;
        for(Users users : usersRepository.getAllUsersFromDB()){
            usersDTO.add(changeToUserDTO(users));
        }
        return usersDTO;
    }
}
