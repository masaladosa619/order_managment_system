package model;

public class userDTO {
    private int userId;
    private String role;

    public userDTO(int userId, String role) {
        this.userId = userId;
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public String getRole() {
        return role;
    }
}
