import Service.userService;
import dao.ProductDAO;
import dao.UserDAO;
import model.Customer;
import model.userDTO;

import model.user;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {



        UserDAO dao = new UserDAO();
         userDTO role = dao.login("testuser", "testpassword");

         int userid = role.getUserId();
         String roles = role.getRole();

        System.out.println("Logged in as: " + roles);

        userService userservice = new userService();
        user user = userservice.login("emp1","pass");

        if(user==null){
            System.out.println("INVALID LOGIN");
    }
        else{
            user.showMenu();
        }

    }
}