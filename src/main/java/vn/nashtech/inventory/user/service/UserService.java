package vn.nashtech.inventory.user.service;

import vn.nashtech.inventory.user.api.dto.SignInRequest;
import vn.nashtech.inventory.user.api.dto.SignUpRequest;
import vn.nashtech.inventory.user.database.model.User;

public interface UserService {
    User signIn(SignInRequest req);
    void signUp(SignUpRequest req);
}
