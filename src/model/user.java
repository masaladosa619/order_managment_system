package model;

import java.sql.SQLException;

public abstract class user {
    protected static int userid;

    public user(int userid) {
        this.userid = userid;
    }

    public static int getuser() {
        return userid;
    }

    public abstract void showMenu() throws SQLException;
}
