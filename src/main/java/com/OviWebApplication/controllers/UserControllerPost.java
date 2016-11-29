package com.OviWebApplication.controllers;

import com.OviWebApplication.domain.User;
import com.OviWebApplication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 *This class takes care of all the RequestMethods POST.
 */

@Controller
public class UserControllerPost {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    /**
     * This method takes all the information inserted about the user and then display the user.
     * @param user represent the object created by the client.
     * @param result binding the result.
     * @return /userform.html if the information inserted is not valid.
     *         /user + id if the information is valid.
     */
    @RequestMapping(value = "user", method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "/userform";
        }
        userService.saveUser(user);
        return "redirect:/user/" + user.getId();
    }


    /**
     * This method handle the Search by first name bar .Search for the first name inserted and return the results.
     * @param firstName the first name request.
     * @param model bind the result of the search.
     * @return /usernotfound.html if the user don`t exist.
     *         /users.html to display the results.
     */
    @RequestMapping(value = "/byFirstName", method = RequestMethod.POST)
    public String byFirstName(@RequestParam("firstName") String firstName, Model model ) {
        if (userService.searchByFirstName(firstName).isEmpty()){
            return "/usernotfound";
        }
        model.addAttribute("userslist", userService.searchByFirstName(firstName));
        return "/users";
    }


    /**
     *This method handle the Search by id bar .Search for the id inserted and return the results.
     * @param model bind the result of the search.
     * @param id the id request.
     * @return /usernotfound.html if the user don`t exist.
     *         /usersshow.html to display the result.
     */
    @RequestMapping(value = "/byId", method = RequestMethod.POST)
    public String byFirstName(Model model, @RequestParam("id") Integer id) {
        if (userService.getUserById(id) == null){
            return "/usernotfound";
        }
        model.addAttribute("user", userService.getUserById(id));
        return "/usershow";
    }


}
