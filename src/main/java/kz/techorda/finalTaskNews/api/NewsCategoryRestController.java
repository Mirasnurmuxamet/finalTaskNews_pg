package kz.techorda.finalTaskNews.api;

import kz.techorda.finalTaskNews.dto.NewsCategoryDTO;
import kz.techorda.finalTaskNews.service.NewsCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/news_categories")
@RequiredArgsConstructor
public class NewsCategoryRestController {

    private final NewsCategoryService newsCategoryService;

    @GetMapping
    public List<NewsCategoryDTO> getNewsCategories(){
        return newsCategoryService.getNewsCategories();
    }


}
