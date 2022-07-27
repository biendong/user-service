package vn.nashtech.inventory.user.api.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        try {
            return ResponseEntity.ok(userService.signIn(request));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    @PostMapping("signup")
    public ResponseEntity<?> signup(@RequestBody SignUpRequest request) {
        try {
            userService.signUp(request);
            return ResponseEntity.ok("Success");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
