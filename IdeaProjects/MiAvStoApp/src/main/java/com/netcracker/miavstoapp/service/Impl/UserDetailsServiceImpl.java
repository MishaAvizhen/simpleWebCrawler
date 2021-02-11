package com.netcracker.miavstoapp.service.impl;

import com.netcracker.miavstoapp.dao.RoleDao;
import com.netcracker.miavstoapp.dao.UserDao;
import com.netcracker.miavstoapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserDao userDao;


    @Override
    public UserDetails loadUserByUsername(String usernme) throws UsernameNotFoundException {
        User user = userDao.findUserByUsername(usernme);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}
