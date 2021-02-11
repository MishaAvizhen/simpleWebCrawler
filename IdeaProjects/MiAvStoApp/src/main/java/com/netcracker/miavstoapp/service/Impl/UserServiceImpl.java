package com.netcracker.miavstoapp.service.impl;


import com.netcracker.miavstoapp.dao.RoleDao;
import com.netcracker.miavstoapp.dao.UserDao;
import com.netcracker.miavstoapp.entity.Role;
import com.netcracker.miavstoapp.entity.User;
import com.netcracker.miavstoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service

public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public boolean saveUser(User user) {
        User userFromDb = userDao.findUserByUsername(user.getUsername());
        if (userFromDb != null) {
            return false;
        }
        user.setRoles(Collections.singleton(new Role(1, "ROLE_USER")));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.save(user);
        return true;
    }

    @Override
    public boolean deleteUser(int userId) {
        if (userDao.findUserById(userId) != null)  {
            userDao.delete(userId);

        }
        return false;
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    @Override
    public User findById(int userId) {
        return userDao.findUserById(userId);
    }


    @Override
    public List<User> allUser() {
        return userDao.findAll();
    }


}
