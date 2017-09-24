package com.laslusen.laslusen.controller;

import com.laslusen.laslusen.core.Bok;
import com.laslusen.laslusen.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;

@RestController
@RequestMapping("/book")
public class Reader {

    @Autowired
    private BookService service;

    @RequestMapping(method = RequestMethod.GET)
    public String index(){
        service.start();
        return "Hej läsvännen!";
    }


}
