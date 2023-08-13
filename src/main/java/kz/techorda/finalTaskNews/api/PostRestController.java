package kz.techorda.finalTaskNews.api;

import kz.techorda.finalTaskNews.dto.PostDTO;
import kz.techorda.finalTaskNews.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
@RequiredArgsConstructor
public class PostRestController {

    private final PostService postService;


    @GetMapping
    public  List<PostDTO> getAllPosts(){
        return postService.getAllLastPosts();
    }



    @PreAuthorize("hasAnyRole('ROLE_AUTHOR', 'ROLE_ADMIN')")
    @PostMapping
    public PostDTO addPost(@RequestBody PostDTO postDTO){
        return postService.addPost(postDTO);
    }



    @GetMapping(value = "{id}")
    public PostDTO getPost(@PathVariable(name = "id") Long id){
        return postService.getPost(id);
    }



    @PreAuthorize("hasAnyRole('ROLE_AUTHOR', 'ROLE_ADMIN')")
    @PutMapping
    public PostDTO updatePost(@RequestBody PostDTO postDTO){
        return postService.updatePost(postDTO);
    }


    @PreAuthorize("hasAnyRole('ROLE_AUTHOR', 'ROLE_ADMIN')")
    @DeleteMapping(value = "{id}")
    public void  deletePost(@PathVariable(name = "id") Long id){
        postService.deletePost(id);
    }


}
