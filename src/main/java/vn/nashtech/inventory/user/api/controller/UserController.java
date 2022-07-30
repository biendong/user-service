package vn.nashtech.inventory.user.api.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import vn.nashtech.inventory.user.api.dto.SignInRequest;
import vn.nashtech.inventory.user.api.dto.SignUpRequest;
import vn.nashtech.inventory.user.api.dto.UserRequest;
import vn.nashtech.inventory.user.api.dto.UserResponse;
import vn.nashtech.inventory.user.database.entity.UserEntity;
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
    
    @ApiOperation(value = "Get list user", nickname = "getListUserUsingGET", notes = "", tags={ "user-controller" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = UserResponse.class),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found") })
    @GetMapping("listUser")
    public ResponseEntity<?> getListUser(){
      List<UserEntity> response = userService.getListUser();
      return ResponseEntity.ok(response);
    }
    
    @ApiOperation(value = "Update user", nickname = "updateUserUsingGET", notes = "", tags={ "user-controller" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = UserResponse.class),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found") })    
    @PostMapping("updateProfile/{id}")
    public ResponseEntity<?> updateProfile(@RequestBody UserRequest userRequest, @PathVariable ("id") Long id){
      UserEntity userEntity = new UserEntity();
      userEntity.setId(id);
      userEntity = userService.updateProfile(userRequest, id);
      return ResponseEntity.ok(userEntity);
    }
}
