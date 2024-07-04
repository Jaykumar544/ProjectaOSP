package com.biit.controller;

import com.biit.entities.User;
import com.biit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {

    @RequestMapping({"/", "/dashboard"})
    public String home()
    {
        return "index";
    }


    @RequestMapping(value="/about")
    public String about()
    {
        return "about";
    }
    @RequestMapping(value="/contact")
    public String contact()
    {
        return "contact";
    }

}
