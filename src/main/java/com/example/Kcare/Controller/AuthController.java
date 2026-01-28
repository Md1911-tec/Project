package com.example.Kcare.Controller;

import com.example.Kcare.Entity.User;
import com.example.Kcare.Repository.UserRepository;
import com.example.Kcare.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
    private UserService userService;
    private UserRepository userRepository;


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Map<String, String> body) {
        String email=body.get("email");
        String password=body.get("password");
        if (userRepository.findByEmail(email).isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists");
        }
    userService.createUser(User.builder().email(email).password(password).build());
        return new ResponseEntity<>("Successfully registered", HttpStatus.CREATED);
    }

//    @PostMapping("/login")
//public ResponseEntity<?> loginUser(@RequestBody Map<String,String> body) {
//    String email=body.get("email");
//    String password=body.get("password");
//    var userOptional=userRepository.findByEmail(email);
//    if (userOptional.isEmpty()){
//        return new ResponseEntity<>("not registered", HttpStatus.UNAUTHORIZED);
//    }
//    User user=userOptional.get();
//    if(!passwordEncoder.matches(password, user.getPassword())){
//        return new ResponseEntity<>("invalid user", HttpStatus.UNAUTHORIZED);
//    }
//    String token=jwitUtil.generateToken(email);
//    return ResponseEntity.ok(Map.of("token",token));
//
//}
}


