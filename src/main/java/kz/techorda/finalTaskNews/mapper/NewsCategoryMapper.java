package kz.techorda.finalTaskNews.mapper;

import kz.techorda.finalTaskNews.dto.NewsCategoryDTO;
import kz.techorda.finalTaskNews.models.NewsCategory;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NewsCategoryMapper {


    NewsCategoryDTO toNewsCategoryDto(NewsCategory newsCategory);
    NewsCategory toNewsCategoryModel(NewsCategoryDTO newsCategoryDTO);

    List<NewsCategoryDTO> toNewsCtegoryDtoList(List<NewsCategory> newsCategoryList);

    List<NewsCategory> toNewsCategoryModelList(List<NewsCategoryDTO> categoryDTOList);
}
