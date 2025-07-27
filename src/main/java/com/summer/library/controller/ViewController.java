package com.summer.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ViewController {

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/books/new")
    public String addBook(){
        return "add-book";
    }

    @GetMapping("/library")
    public String showLibrary(){
        return "library-view";
    }

    @GetMapping("/about")
    public String showAbout(){
        return "about";
    }
    @GetMapping("/services")
    public String showServices(){
        return "services";
    }
    @GetMapping("/pricing")
    public String showPricing(){
        return "pricing";
    }
    @GetMapping("/contact")
    public String showContact(){
        return "contact";
    }
}
