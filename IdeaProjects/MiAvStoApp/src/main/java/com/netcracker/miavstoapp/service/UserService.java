package com.netcracker.miavstoapp.service;

import com.netcracker.miavstoapp.entity.User;

import java.util.List;


public interface UserService {
    boolean saveUser(User user);
    boolean deleteUser(int userId);

    User findByUsername(String username);

    User findById(int userId);
    List<User> allUser();


}
