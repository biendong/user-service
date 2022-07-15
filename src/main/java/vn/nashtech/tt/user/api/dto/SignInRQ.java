package vn.nashtech.tt.user.api.dto;

import lombok.Data;

@Data
public class SignInRQ {
    private String username;
    private String password;
}
