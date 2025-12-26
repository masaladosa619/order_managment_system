package dao;
import database.Dbconnection;
import model.userDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    static public userDTO login(String username, String password) throws SQLException {
        Connection con = Dbconnection.getConnection();
        String sql = "SELECT userid,role FROM users WHERE username = ? AND password_hash = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,username);
        ps.setString(2,password);
        ResultSet rs = ps.executeQuery();

        if(rs.next()){
            return new userDTO(rs.getInt("userid"), rs.getString("role"));
        }
        return null;

    }



}
