package com.biit.controller;

import com.biit.entities.Feedback;
import com.biit.entities.User;
import com.biit.repositories.FeedbackRepository;
import com.biit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController {


    @Autowired
    UserRepository userRepository;
//    @Autowired
    PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    @RequestMapping(value="/login")
    public String login()
    {
        return "login";
    }

    @RequestMapping(value = "/doLogin")
    public ModelAndView doLogin(@RequestParam String email, @RequestParam String password, HttpServletRequest request)
    {
        ModelAndView modelAndView = new ModelAndView();
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if(optionalUser.isPresent())
        {
            User user = optionalUser.get();
            System.out.println(user);
            if(user.getPassword().equals(password))
            {
                HttpSession httpSession = request.getSession();
                System.out.println("Successfully logged in.");
                return userUpdate(user.getId());
            }
            else
            {
                System.out.println("Incorrect password. - Login error.");
                modelAndView.setViewName("login");
            }
        }
        else
        {
            System.out.println("User not found, Sign up first.");
            modelAndView.setViewName("signup");
        }
        return modelAndView;
    }

    @RequestMapping("/signup")
    public String signup()
    {
        return "signup";
    }


    @RequestMapping(value = "/doSignup")
    public String doSignup(@ModelAttribute User user)
    {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "signup";
    }


    @RequestMapping("/usersReport")
    public ModelAndView usersReport()
    {
        List<User> users = userRepository.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("users",users);
        modelAndView.setViewName("usersReport");
        return  modelAndView;
    }

    @RequestMapping("/deleteUser/{id}")
    public ModelAndView deleteUser(@PathVariable int id)
    {
        Optional<User> optionalUser=userRepository.findById(id);
        if(optionalUser.isPresent())
            userRepository.delete(optionalUser.get());
        else
            System.out.println("User not found.");
        return usersReport();
    }

    @RequestMapping("/userUpdate/{id}")
    public ModelAndView userUpdate(@PathVariable int id)
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userUpdate");
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent())
        {
            User user = optionalUser.get();
            modelAndView.addObject("userId",user.getId());
            modelAndView.addObject("userName",user.getName());
            modelAndView.addObject("userEmail",user.getEmail());
            modelAndView.addObject("userPhone",user.getPhone());
            modelAndView.addObject("userAddress",user.getAddress());
        }
        else
        {
            System.out.println("user not found.");
        }
        return modelAndView;
    }

    @RequestMapping("/userUpdateProcess/{id}")
    public ModelAndView userUpdateProcess(@PathVariable int id, @ModelAttribute User user)
    {
        user.setId(id);
        User dbUser = userRepository.findById(id).get();

        if(user.getPassword().isEmpty())
        {
            user.setPassword(dbUser.getPassword());
        }
        else
        {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        userRepository.save(user);
        return usersReport();
    }



}
