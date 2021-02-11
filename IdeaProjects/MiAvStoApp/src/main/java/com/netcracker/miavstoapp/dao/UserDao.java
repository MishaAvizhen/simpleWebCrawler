package com.netcracker.miavstoapp.dao;

import com.netcracker.miavstoapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Александр on 10.02.2021.
 */
public interface UserDao extends JpaRepository<User, Integer> {
    User findUserByUsername(String username);

    User findUserById(int userId);

}
