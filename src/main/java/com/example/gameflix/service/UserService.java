package com.example.gameflix.service;
import com.example.gameflix.model.User;

public interface UserService {
    String registerUser(User user);
    String loginUser(String username,String password);
}
