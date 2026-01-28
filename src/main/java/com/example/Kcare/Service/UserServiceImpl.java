package com.example.Kcare.Service;

import com.example.Kcare.Dto.ClientIndividualRequestDTO;
import com.example.Kcare.Entity.ClientIndividual;
import com.example.Kcare.Entity.User;
import com.example.Kcare.Repository.ClientIndividualRepository;
import com.example.Kcare.Repository.UserRepository;
//import com.example.Kcare.Security.JwitUtil;
import lombok.AllArgsConstructor;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
   // private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
 //   private JwitUtil jwitUtil;
    private ClientIndividualRepository clientRepository;
@Override
  public User createUser(User user){
    if(userRepository.existsByEmail(user.getEmail())){
        throw new RuntimeException("Already user exists "+user.getEmail());
    }
    User createuser=new User();
      createuser.setFirstName(user.getFirstName());
      createuser.setLastName(user.getLastName());
      createuser.setPassword(user.getPassword());
  //  user.setPassword(passwordEncoder.encode(user.getPassword()));
      createuser.setEmail(user.getEmail());
      createuser.setPhone(user.getPhone());
      createuser.setGender(user.getGender());
      createuser.setDob(user.getDob());
  //  ClientIndividual client = clientRepository.findById(clientid).orElseThrow(() -> new RuntimeException("Client not found"));
  //  user.setClientIndividual(client);

    return userRepository.save(createuser);
  }



    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

    }

@Override
    public String createAndLinkClientIndividual(
            Long userId,
            ClientIndividualRequestDTO dto) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    if (user.getClientIndividual() != null) {
        throw new RuntimeException("ClientIndividual already exists");
    }

        ClientIndividual client = new ClientIndividual();
        client.setFirstName(dto.getFirstName());
        client.setLastName(dto.getLastName());
        client.setDob(dto.getDob());
        client.setSsn(dto.getSsn());
        client.setGender(dto.getGender());
//        client.setMdmId(dto.getMdmId());
//        client.setIrnId(dto.getIrnId());
        clientRepository.save(client);

       user.setClientIndividual(client);

        // (optional – bidirectional irundha)
        client.setUser(user);
        userRepository.save(user);
        return "Client linked successfully with User ID: "+userId;
    }
    @Override
    public ClientIndividual getClientIndividualById(Long clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client Individual not found"));
    }

}


