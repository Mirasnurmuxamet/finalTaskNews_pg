package kz.techorda.finalTaskNews.api;

import kz.techorda.finalTaskNews.dto.PostDTO;
import kz.techorda.finalTaskNews.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/news_category_posts")
@RequiredArgsConstructor
public class NewsCategoryPostsRestController {

    private final PostService postService;

    @GetMapping(value = "{newsCategory}")
    public List<PostDTO> getPostsByCategories(@PathVariable(name = "newsCategory") String newsCategory){
        return postService.getPostsByNewsCategory(newsCategory);
    }


}
