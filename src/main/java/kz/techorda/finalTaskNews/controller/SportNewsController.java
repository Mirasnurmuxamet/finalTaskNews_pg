package kz.techorda.finalTaskNews.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SportNewsController {

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/sport_news")
    public String sportNewsPage(){
        return "sportNews";
    }





}
