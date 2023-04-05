package Service;

import DTOs.UsersDTO;
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

    private final ChangeClassService changeClassService = new ChangeClassService();

    @Override
    public void login(int id, String password) throws SQLException {

        final Users loggedUser = usersRepository.getLoggedUserFromDB(id, password);

        if(loggedUser != null){
            if(teachersRepository.getAllTeachersFromDB().stream().anyMatch(teacher -> teacher.getId()==loggedUser.getId())){};
            if(studentsRepository.getAllStudentsFromDB().stream().anyMatch(student -> student.getId()==loggedUser.getId())){};
            if(usersRepository.itsAdmin(loggedUser)){};
        }

    }

    public void createUserDTOInDB(UsersDTO user){
        usersRepository.setNewUserInDB(changeClassService.changeToUserEntity(user));
    }

    public void changePasswordOfUserDTO(UsersDTO user){
        Users usersEntity = changeClassService.changeToUserEntity(user);
        usersRepository.modifyPasswordUserInDB(usersEntity.getId(), usersEntity.getPassword());
    }

    public void deleteUserDTOFromDB(UsersDTO user){
        usersRepository.deleteUserInDB(changeClassService.changeToUserEntity(user).getId());
    }

    public UsersDTO getUserDTOFromDBByID(int id){
        return changeClassService.changeToUserDTO(usersRepository.getUserByIDFromDB(id));
    }

    public List<UsersDTO> usersList() {
        List<UsersDTO> usersDTO = null;
        for(Users users : usersRepository.getAllUsersFromDB()){
            usersDTO.add(changeClassService.changeToUserDTO(users));
        }
        return usersDTO;
    }
}
