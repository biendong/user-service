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
            throw new RuntimeException("Username does not exist");
        } else {
            Boolean check = BCrypt.checkpw(req.getPassword(), user.getPassword());
            if (!check) {
                throw new RuntimeException("Incorrect password");
            } else {
                return user;
            }
        }
    }

    @Override
    public void signUp(SignUpRequest req) {
        UserEntity checkUser = userRepository.findByUsername(req.getUsername());
        if (checkUser != null) {
            throw new RuntimeException("Username exist");
        } else {
            UserEntity user = new UserEntity();
            user.setUsername(req.getUsername());
            user.setPassword(BCrypt.hashpw(req.getPassword(), BCrypt.gensalt(10)));
            user.setFirstName(req.getFirstName());
            user.setLastName(req.getLastName());
            user.setEmail(req.getEmail());
            userRepository.save(user);
        }
    }
}
