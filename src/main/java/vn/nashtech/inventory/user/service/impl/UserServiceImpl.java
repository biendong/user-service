package vn.nashtech.inventory.user.service.impl;

import lombok.extern.slf4j.Slf4j;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.nashtech.inventory.user.api.dto.SignInRequest;
import vn.nashtech.inventory.user.api.dto.SignUpRequest;
import vn.nashtech.inventory.user.api.dto.UserRequest;
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
    @Override
    public UserEntity updateProfile(UserRequest req, Long id) {
      UserEntity user = userRepository.findById(id).orElse(null);
      if(user != null){
        user.setId(id);
        user.setUsername(req.getUsername());
        user.setPassword(req.getPassword());
        user.setEmail(req.getEmail());
        user.setFirstName(req.getFirstName());
        user.setLastName(req.getLastName());
        return userRepository.save(user);
      }
      return null;
    }
    @Override
    public List<UserEntity> getListUser() {
      List<UserEntity> listUser = (List<UserEntity>) userRepository.findAll();
      if(!listUser.isEmpty()) {
        return listUser;
      }
      return null;
    }
}
