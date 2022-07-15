package vn.nashtech.tt.user.service;

import vn.nashtech.tt.user.api.dto.SignInRQ;

public interface UserService {
    void signIn(SignInRQ req);
}
