package com.vn.devmaster.quanlysinhvien.demosinhvien.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class CommonController {

    @GetMapping("")
    public String showIndex(){
        return "layout/index";
    }
}
