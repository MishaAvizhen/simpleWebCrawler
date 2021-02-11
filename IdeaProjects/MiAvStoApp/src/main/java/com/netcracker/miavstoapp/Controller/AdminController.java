package com.netcracker.miavstoapp.controller;

import com.netcracker.miavstoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String userList(Model model) {
        model.addAttribute("allUsers", userService.allUser());
        return "admin";
    }
    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public String  deleteUser(@RequestParam(required = true, defaultValue = "" ) int userId,
                              @RequestParam(required = true, defaultValue = "" ) String action,
                              Model model) {
        if (action.equals("delete")){
            userService.deleteUser(userId);
        }

        return "redirect:/admin";
    }

}
