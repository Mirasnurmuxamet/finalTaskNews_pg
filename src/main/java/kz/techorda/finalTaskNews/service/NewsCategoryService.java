package kz.techorda.finalTaskNews.service;

import kz.techorda.finalTaskNews.dto.NewsCategoryDTO;
import kz.techorda.finalTaskNews.mapper.NewsCategoryMapper;
import kz.techorda.finalTaskNews.repository.NewsCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsCategoryService {

    private final NewsCategoryRepository newsCategoryRepository;

    private  final NewsCategoryMapper newsCategoryMapper;

    public List<NewsCategoryDTO> getNewsCategories(){
        return newsCategoryMapper.toNewsCtegoryDtoList(newsCategoryRepository.findAll());
    }




}
