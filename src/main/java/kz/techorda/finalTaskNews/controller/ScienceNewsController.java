package kz.techorda.finalTaskNews.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ScienceNewsController {

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/science_news")
    public String scienceNewsPage(){
        return "scienceNews";
    }


}
