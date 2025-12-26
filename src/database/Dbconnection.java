package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {
    static String url = "jdbc:postgresql://localhost:5432/order_managment"; //this was used to give the link to the sql server(postgresql)
    static String username = "postgres";
    static String password = "apna_password_daal_mc";

    public static Connection getConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, username, password);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }


        return con;
    }
}
