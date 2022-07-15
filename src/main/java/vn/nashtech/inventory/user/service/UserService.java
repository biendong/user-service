package vn.nashtech.inventory.user.service;

import vn.nashtech.inventory.user.api.dto.SignInRequest;

public interface UserService {
    void signIn(SignInRequest req);
}
