package vn.nashtech.inventory.user.database.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String lastName;
    private String firstName;
}
