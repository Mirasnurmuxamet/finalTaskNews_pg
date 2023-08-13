package kz.techorda.finalTaskNews.api;

import kz.techorda.finalTaskNews.dto.CommentDTO;
import kz.techorda.finalTaskNews.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/comments")
@RequiredArgsConstructor
public class CommentRestController {

    private  final CommentService commentService;

    @GetMapping(value = "{id}")
    public List<CommentDTO> getCommentList(@PathVariable(name = "id") Long id ){
        return commentService.getComments(id);
    }


    @PostMapping
    public CommentDTO addComment(@RequestBody CommentDTO commentDTO){
        return commentService.addComment(commentDTO);
    }


    @DeleteMapping(value = "{id}")
    public  void  deleteComment(@PathVariable(name = "id") Long id ){
        commentService.deleteComment(id);
    }

}
