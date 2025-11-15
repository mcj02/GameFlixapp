package com.example.gameflix.service;
import com.example.gameflix.model.User;
import com.example.gameflix.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public String registerUser(User user) {
        Optional<User> existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser.isPresent()) {
            return "User already exists";
        }
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
        return "User registered successfully";
    }
    @Override
    public String loginUser(String username,String password) {
        Optional<User> userLog = userRepository.findByUsername(username);
        if (userLog.isEmpty()) {
            return "User not found";
        }
        User user = userLog.get();
        boolean matches = passwordEncoder.matches(password, user.getPassword());
        if (matches) {
            return "Logged in successfully";
        } else {
            return "Wrong password";
        }
    }
}




