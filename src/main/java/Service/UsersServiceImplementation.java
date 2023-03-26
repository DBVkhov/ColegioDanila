package Service;

import DTOs.UsersDTO;
import Repository.Entities.Users;
import Repository.UsersRepository;

import java.util.List;

public class UsersServiceImplementation implements UsersService {

    private final UsersRepository usersRepository = new UsersRepository();

    private final Users usersLogged = null;

    @Override
    public void login(int id, String password){

        Users loggedUsers = null;

        loggedUsers = usersRepository.getLoggedUserFromDB(id, password);
        if(loggedUsers != null){
            if(){};
            else if(){};
            else if(){};
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

    @Override
    public List<UsersDTO> usersList() {
        List<UsersDTO> usersDTO = null;
        for(Users users : usersRepository.getAllUsersFromDB()){
            usersDTO.add(changeToUserDTO(users));
        }
        return usersDTO;
    }
}
