package Service;
import dao.UserDAO;
import dao.orderDAO;
import model.*;

import java.sql.SQLException;


public class userService {
    private UserDAO userDAO = new UserDAO();
    public user login(String username, String password) throws SQLException {

        userDTO userdata = UserDAO.login(username, password);

        int userid = userdata.getUserId();
        String role = userdata.getRole();


        if(role==null){
            return null;
        }

        if(role.equals("USER")){
            return new Customer(userid);
        }
        if (role.equals("EMPLOYEE")){
            return new Employee(userid);
        }
        if (role.equals("Manager")){
            return new Manager(userid);
        }
        return null;
    }



}
