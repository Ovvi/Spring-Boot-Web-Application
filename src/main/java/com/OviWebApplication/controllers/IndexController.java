package com.OviWebApplication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Ovi on 11/20/2016.
 */

@Controller
public class IndexController {

    @RequestMapping("/")
    String index(){
        return "index";
    }
}
