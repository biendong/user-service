package vn.nashtech.inventory.user.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequest {
    private String username;
    private String password;
    private String fullName;
    private String firstName;
    private String lastName;
}
