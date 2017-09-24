package com.laslusen.laslusen.controller;

import com.laslusen.laslusen.service.BookService;
import com.laslusen.laslusen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/")
public class User {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    public String start(){
//    public ModelAndView index(HttpServletRequest request,
//                        HttpServletResponse response) throws Exception {

//        ModelAndView model = new ModelAndView("user");
//        model.addObject("msg", "hello world");
//
//        service.start();
//        return model;
        return "Är du ny här?";
    }

}
