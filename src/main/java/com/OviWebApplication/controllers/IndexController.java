package com.OviWebApplication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This class its used to set the index Controller.
 */

@Controller
public class IndexController {

    @RequestMapping("/")
    String index(){
        return "index";
    }
}
