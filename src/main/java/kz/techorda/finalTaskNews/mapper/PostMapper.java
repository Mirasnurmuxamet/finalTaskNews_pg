package kz.techorda.finalTaskNews.mapper;

import kz.techorda.finalTaskNews.dto.PostDTO;
import kz.techorda.finalTaskNews.models.Post;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {

    PostDTO toPostDto(Post post);

    Post toPostModel(PostDTO postDTO);

    List<PostDTO> toPostDtoList(List<Post> postList);

    List<Post> toPostModellist(List<PostDTO> postDTOList);
}
