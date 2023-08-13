package kz.techorda.finalTaskNews.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PoliticalNewsController {

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/political_news")
    public String politicalNewsPage(){
        return "politicalNews";
    }







}
