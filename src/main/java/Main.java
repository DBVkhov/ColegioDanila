import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import Service.UsersServiceImplementation;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader buffered = new BufferedReader(new InputStreamReader(System.in));
        UsersServiceImplementation service = new UsersServiceImplementation();

        System.out.println("ID:");
        int id = Integer.parseInt(buffered.readLine());
        System.out.println("password:");
        String password = buffered.readLine();

        service.login(id, password);
    }
}