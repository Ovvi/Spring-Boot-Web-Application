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
 * This class takes care of all the RequestMethods GET.
 */
@Controller
public class UserControllerGet {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * Responsible for get all the users and display them.
     * @param model bind the users to the model.
     * @return /users.html to view the users.
     */
    @RequestMapping(value = "/usersList", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("userslist", userService.listAllUsers());
        return "/users";
    }


    /**
     * This method get the id of the user selected and return the view.
     * @param id Integer variable to store the user id selected.
     * @param model bind the user selected to the model.
     * @return /users.html to see the user selected.
     */
    @RequestMapping("/user/{id}")
    public String showUser(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "/usershow";
    }


    /**
     * This method get the user selected , bind to the model and return the view for edit the user.
     * @param id Integer variable to store the user id selected.
     * @param model bind the user selected to the model.
     * @return /userform.html for editing the user.
     */
    @RequestMapping("/user/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "/userform";
    }


    /**
     * Method responsible for deleting a selected user.
     * @param id  Integer variable to store the user id selected.
     * @return redirect to /usersList to update the users.
     */
    @RequestMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return "redirect:/usersList";
    }


    /**
     * This method help to get a new instance of a user to be able to insert a new User to the database.
     * @param model bind the new User to the model.
     * @return /userform.html to be able to insert all the information about the user.
     */
    @RequestMapping("/user/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "/userform";
    }


}
