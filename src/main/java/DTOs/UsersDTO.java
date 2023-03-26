package DTOs;

public class UsersDTO {

    private int id;
    private String password;

    public UsersDTO(int id, String password) {
        this.id = id;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString(){
        return "ID: " + id +
                "\r password: " + password;
    }

}