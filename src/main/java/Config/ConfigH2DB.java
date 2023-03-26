package Config;

import java.sql.*;

public class ConfigH2DB {

    private static Connection connection;

    private static Connection dataConnection() throws SQLException {

        String url = "jdbc:h2:file:~/db/h2/colegio;" +
                "INIT=runscript from 'src/main/resources/sql/create.sql'\\;" +
                "runscript from 'src/main/resources/sql/init.sql'";

        String username = "sa";
        String password = "1234";

        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ConfigH2DB() throws SQLException {
        connection = dataConnection();
    }

    public static Connection getConnection() throws SQLException {
        if(connection == null){
            connection = dataConnection();
        }
        return connection;
    }

    public static void closeConectiion() throws SQLException {
        dataConnection().close();
    }

}
