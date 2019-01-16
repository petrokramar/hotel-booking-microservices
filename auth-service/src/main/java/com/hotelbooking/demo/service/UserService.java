package com.hotelbooking.demo.service;

import com.hotelbooking.demo.model.Role;
import com.hotelbooking.demo.model.User;
import com.hotelbooking.demo.model.dto.UserRegistrationDto;
import com.hotelbooking.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service("userDetailsService")
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MailService mailService;

    @Value("${hostname}")
    private String hostname;

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
                .password(passwordEncoder.encode(userReg.getPassword()))
                .email(userReg.getEmail())
                .activationCode(UUID.randomUUID().toString())
                .enabled(false)
                .authorities(Collections.singleton(Role.USER))
                .build();
        userRepository.save(user);
//        sendMessage(user);
    }

    public boolean activateUser(String code) {
        User user = userRepository.findByActivationCode(code);
        if (user == null) {
            return false;
        }
        user.setActivationCode("");
        user.setEnabled(true);
        userRepository.save(user);
        return true;
    }

    private void sendMessage(User user) {
        if (!StringUtils.isEmpty(user.getEmail())) {
            String message = String.format(
                    "Hello, %s! \n" +
                            "Welcome to Hotelbooking. Please, visit next link: http://%s/activate/%s",
                    user.getUsername(),
                    hostname,
                    user.getActivationCode()
            );
            mailService.send(user.getEmail(), "Activation code", message);
        }
    }
}