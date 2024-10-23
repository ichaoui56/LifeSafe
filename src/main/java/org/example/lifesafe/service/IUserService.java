package org.example.lifesafe.service;

import org.example.lifesafe.model.entities.User;

public interface IUserService {
    boolean registerUser(User user);
    boolean loginUser(String email, String password);

    User getUserByEmail(String email);

    String hashPassword(String password);
    boolean checkPassword(String plainPassword, String hashedPassword);
}