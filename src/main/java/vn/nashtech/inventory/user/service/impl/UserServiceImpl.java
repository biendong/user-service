package vn.nashtech.inventory.user.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.nashtech.inventory.user.api.dto.SignInRequest;
import vn.nashtech.inventory.user.api.dto.SignUpRequest;
import vn.nashtech.inventory.user.database.entity.UserEntity;
import vn.nashtech.inventory.user.database.model.User;
import vn.nashtech.inventory.user.database.repository.UserRepository;
import vn.nashtech.inventory.user.service.UserService;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User signIn(SignInRequest req) {
        UserEntity user = userRepository.findByUsername(req.getUsername());
        if (user == null) {
            return null;
        } else {
            Boolean check = BCrypt.checkpw(req.getPassword(), user.getPassword());
            if (!check) {
                return null;
            } else {
                return user;
            }
        }
    }

    @Override
    public void signUp(SignUpRequest req) {
        UserEntity user = new UserEntity();
        user.setUsername(req.getUsername());
        user.setPassword(BCrypt.hashpw(req.getPassword(), BCrypt.gensalt(10)));
        userRepository.save(user);
    }
}
