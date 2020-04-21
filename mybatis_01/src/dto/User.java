package dto;

public class User {
    private String username;
    private int password;
    private Boolean math;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password=" + password +
                ", math=" + math +
                '}';
    }
}
