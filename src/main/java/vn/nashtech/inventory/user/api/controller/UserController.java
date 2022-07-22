package vn.nashtech.inventory.user.api.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.nashtech.inventory.user.api.dto.SignInRequest;
import vn.nashtech.inventory.user.api.dto.SignUpRequest;
import vn.nashtech.inventory.user.service.UserService;

@RestController
@RequestMapping("/")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("signin")
    public ResponseEntity<?> signIn(@RequestBody SignInRequest request) {
        return ResponseEntity.ok(userService.signIn(request));
    }

    @PostMapping("signup")
    public ResponseEntity<?> signup(@RequestBody SignUpRequest request) {
        userService.signUp(request);
        return ResponseEntity.ok("Success");
    }
}
