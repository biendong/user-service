package vn.nashtech.inventory.user.service;

import java.util.List;
import vn.nashtech.inventory.user.api.dto.SignInRequest;
import vn.nashtech.inventory.user.api.dto.SignUpRequest;
import vn.nashtech.inventory.user.api.dto.UserRequest;
import vn.nashtech.inventory.user.database.entity.UserEntity;
import vn.nashtech.inventory.user.database.model.User;

public interface UserService {
    User signIn(SignInRequest req);
    void signUp(SignUpRequest req);
    
    UserEntity updateProfile(UserRequest req, Long id);
    List<UserEntity> getListUser();
}
