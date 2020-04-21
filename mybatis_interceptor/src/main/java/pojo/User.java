package pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString(exclude = "accounts")
public class User {
    private Integer id;
    private String username;
    private List<Account> accounts;
}
