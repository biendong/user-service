package vn.nashtech.inventory.user.api.dto;

import lombok.Data;

@Data
public class SignInRequest {
    private String username;
    private String password;
}
