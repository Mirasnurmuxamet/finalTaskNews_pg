package kz.techorda.finalTaskNews.service;

import kz.techorda.finalTaskNews.dto.PostDTO;
import kz.techorda.finalTaskNews.mapper.PostMapper;
import kz.techorda.finalTaskNews.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    private final PostMapper postMapper;



    public PostDTO getPost(Long id){
        return postMapper.toPostDto(postRepository.findById(id).orElseThrow());

    }


    public PostDTO addPost(PostDTO postDTO){
        return postMapper.toPostDto(postRepository.save(postMapper.toPostModel(postDTO)));
    }


    public PostDTO updatePost(PostDTO postDTO){
        return postMapper.toPostDto(postRepository.save(postMapper.toPostModel(postDTO)));
    }


    public void deletePost(Long id){
        postRepository.deleteById(id);
    }


    public List<PostDTO> getAllLastPosts(){
        return postMapper.toPostDtoList(postRepository.findTop50ByOrderByPostTimeDesc());
    }


    public  List<PostDTO> getPostsByUserId(Long id){
        return postMapper.toPostDtoList(postRepository.findAllByUserIdOrderByPostTimeDesc(id));
    }



    public  List<PostDTO> getPostsByNewsCategory(String newsCategory){
        return postMapper.toPostDtoList(postRepository.findTop50ByNewsCategory_NameOrderByPostTimeDesc(newsCategory));
    }




}
