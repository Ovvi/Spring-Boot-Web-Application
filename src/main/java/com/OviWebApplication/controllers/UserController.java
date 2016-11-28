package com.OviWebApplication.controllers;

import com.OviWebApplication.domain.User;
import com.OviWebApplication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Ovi on 11/21/2016.
 */
@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/usersList", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("userslist", userService.listAllUsers());
        return "users";
    }

    @RequestMapping("/user/{id}")
    public String showUser(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "usershow";
    }

    @RequestMapping("/user/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "userform";
    }

    @RequestMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return "redirect:/usersList";
    }

    @RequestMapping("/user/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "/userform";
    }

    @RequestMapping(value = "user", method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "/userform";
        }
        userService.saveUser(user);
        return "redirect:/user/" + user.getId();
    }

    @RequestMapping(value = "/byFirstName", method = RequestMethod.POST)
    public String byFirstName(@RequestParam("firstName") String firstName, Model model ) {
        if (userService.searchByFirstName(firstName).isEmpty()){
            return "/usernotfound";
        }
        model.addAttribute("userslist", userService.searchByFirstName(firstName));
        return "/users";
    }

    @RequestMapping(value = "/byId", method = RequestMethod.POST)
    public String byFirstName(Model model, @RequestParam("id") Integer id) {
        if (userService.getUserById(id) == null){
            return "/usernotfound";
        }
        model.addAttribute("user", userService.getUserById(id));
        return "/usershow";
    }




}
