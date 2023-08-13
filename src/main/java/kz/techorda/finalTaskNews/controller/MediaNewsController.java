package kz.techorda.finalTaskNews.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MediaNewsController {

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/media_news")
    public String mediaNewsPage(){
        return "mediaNews";
    }


}
