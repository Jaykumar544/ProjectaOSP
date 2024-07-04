package com.biit.controller;

import com.biit.entities.Feedback;
import com.biit.entities.User;
import com.biit.repositories.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class FeedbackController {

    @Autowired
    FeedbackRepository feedbackRepository;

    @RequestMapping("/feedback")
    public String feedback()
    {
        return "feedback";
    }

    @RequestMapping("/submitFeedback")
    public String submitFeedback(@ModelAttribute Feedback feedback)
    {
        feedbackRepository.save(feedback);
        return "feedback";
    }

    @RequestMapping("/feedbacksReport")
    public ModelAndView feedbacksReport()
    {
        List<Feedback> feedbacks = feedbackRepository.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("feedbacks",feedbacks);
        modelAndView.setViewName("feedbacksReport");
        return  modelAndView;
    }

    @RequestMapping("/deleteFeedback/{id}")
    public ModelAndView deleteFeedback(@PathVariable int id)
    {
        Optional<Feedback> optionalUser=feedbackRepository.findById(id);
        if(optionalUser.isPresent())
            feedbackRepository.delete(optionalUser.get());
        else
            System.out.println("Feedback not found.");
        return feedbacksReport();
    }
}
