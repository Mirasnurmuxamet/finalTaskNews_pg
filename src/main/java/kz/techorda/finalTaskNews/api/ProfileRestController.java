package kz.techorda.finalTaskNews.api;


import kz.techorda.finalTaskNews.dto.PostDTO;
import kz.techorda.finalTaskNews.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/profile")
@RequiredArgsConstructor
public class ProfileRestController {

    private final PostService postService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_AUTHOR')")
    @GetMapping(value = "{id}")
    public List<PostDTO> getUserPosts(@PathVariable(name = "id") Long id){
        List<PostDTO> postDTOList = postService.getPostsByUserId(id);
        return postDTOList;
    }

}
