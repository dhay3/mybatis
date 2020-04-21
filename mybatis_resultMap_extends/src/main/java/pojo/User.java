package pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private Integer id;
    private String username;
    private String address;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }
}
