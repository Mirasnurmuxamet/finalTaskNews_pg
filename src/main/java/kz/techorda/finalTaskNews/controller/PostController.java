package kz.techorda.finalTaskNews.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class PostController {

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/post_details/{id}")
    public String postDetails(@PathVariable(name = "id") Long id, Model model){
        model.addAttribute("postId", id);
        return "postDetails";
    }



}
