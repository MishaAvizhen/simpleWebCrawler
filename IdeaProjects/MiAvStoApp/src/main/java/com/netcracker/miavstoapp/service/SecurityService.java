package com.netcracker.miavstoapp.service;

/**
 * Created by Александр on 10.02.2021.
 */
public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
