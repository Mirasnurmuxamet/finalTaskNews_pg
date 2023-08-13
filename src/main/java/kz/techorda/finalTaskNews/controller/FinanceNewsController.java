package kz.techorda.finalTaskNews.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class FinanceNewsController {

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/finance_news")
    public String financeNewsPage(){
        return "financeNews";
    }



}
