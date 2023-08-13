package kz.techorda.finalTaskNews.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BusinessNewsController {

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/business_news")
    public String businessNewsPage(){
        return "businessNews";
    }


}
