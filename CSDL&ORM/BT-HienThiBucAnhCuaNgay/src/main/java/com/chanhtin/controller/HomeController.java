package com.chanhtin.controller;

import com.chanhtin.model.Comment;
import com.chanhtin.service.BaseService;
import com.chanhtin.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private BaseService<Comment> service;

    private List<Comment> getComment(){
        List<Comment> comments = new ArrayList<>(service.findAll());
        return comments;
    }


    @GetMapping
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("comment", new Comment());
        modelAndView.addObject("comments", getComment());
        return modelAndView;
    }

    @PostMapping
    public ModelAndView addComment(@ModelAttribute("comments") Comment comment){
        service.add(comment);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("comment", new Comment());
        modelAndView.addObject("comments", getComment());
        return modelAndView;
    }

    @GetMapping("/like/{id}")
    public ModelAndView likeComment(@PathVariable Long id ){
        Comment comment= service.findByID(id);
        comment.setLikes(comment.getLikes()+1);
        service.save(comment);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("comment", new Comment());
        modelAndView.addObject("comments", getComment());
        return modelAndView;
    }


}
