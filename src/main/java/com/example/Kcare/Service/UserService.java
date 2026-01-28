package com.example.Kcare.Service;

import com.example.Kcare.Dto.ClientIndividualRequestDTO;
import com.example.Kcare.Entity.ClientIndividual;
import com.example.Kcare.Entity.User;
//import org.springframework.security.core.userdetails.UserDetails;


public interface UserService {
    public User createUser(User user);
    User getUserById(Long userId);
   public String createAndLinkClientIndividual(
           Long userId,
           ClientIndividualRequestDTO dto);
    public ClientIndividual getClientIndividualById(Long clientId);
//    public ResponseEntity<?> loginUser(Map<String,String> body);
//ResponseEntity<String> registerUser(Map<String,String> body);
}
