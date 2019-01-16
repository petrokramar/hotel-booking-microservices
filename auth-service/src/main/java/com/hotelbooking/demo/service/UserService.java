package com.hotelbooking.demo.service;

import com.hotelbooking.demo.model.Role;
import com.hotelbooking.demo.model.User;
import com.hotelbooking.demo.model.dto.UserRegistrationDto;
import com.hotelbooking.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service("userDetailsService")
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private UserRepository userRepository;
//    private MailSender mailSender;

//    @Value("${hostname}")
//    private String hostname;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository.findOneByUsername(username);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void register(UserRegistrationDto userReg) {
        User user = User
                .builder()
                .username(userReg.getUsername())
                .password(userReg.getPassword())
                .email(userReg.getEmail())
                .activationCode(UUID.randomUUID().toString())
                .enabled(false)
                .authorities(Collections.singleton(Role.USER))
                .build();
        userRepository.save(user);
    }

//    private void sendMessage(User user) {
//        if (!StringUtils.isEmpty(user.getEmail())) {
//            String message = String.format(
//                    "Hello, %s! \n" +
//                            "Welcome to Hotelbooking. Please, visit next link: http://%s/activate/%s",
//                    user.getUsername(),
//                    hostname,
//                    user.getActivationCode()
//            );
//
//            mailSender.send(user.getEmail(), "Activation code", message);
//        }
//    }
}