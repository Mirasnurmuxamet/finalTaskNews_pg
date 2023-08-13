package kz.techorda.finalTaskNews.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class TechnologyNewsController {

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/technology_news")
    public String technologyNewsPage(){
        return "technologyNews";
    }


}
