package com.example.Kcare.Controller;

import com.example.Kcare.Dto.ClientIndividualRequestDTO;
import com.example.Kcare.Entity.ClientIndividual;
import com.example.Kcare.Service.UserService;
import com.example.Kcare.Entity.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
public class UserController {
    private UserService userService;
private JavaMailSender ms;

    @PostMapping("/user/create")
    public ResponseEntity<?> userCreate(@RequestBody User user) {
        try {
            User createduser=userService.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(createduser);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("error",e.getMessage()));
        }
    }


    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/mail")
    public String mail(@RequestParam String email){
        SimpleMailMessage msg=new SimpleMailMessage();
        msg.setTo(email);
        msg.setSubject("welcome");
        msg.setText("vanakam da mapla");
        ms.send(msg);
        return "mail send successfully";

    }

    @PostMapping("/user-client/{userId}")
    public String createClientAndLinkUser(@PathVariable
            Long userId,
           @RequestBody ClientIndividualRequestDTO dto){
        return userService.createAndLinkClientIndividual(userId, dto);
    }
    @GetMapping("/user/client/{id}")
    public ClientIndividual getClient(@PathVariable Long id) {
        return userService.getClientIndividualById(id);
    }
}
