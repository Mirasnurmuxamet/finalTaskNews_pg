package kz.techorda.finalTaskNews.mapper;

import kz.techorda.finalTaskNews.dto.CommentDTO;
import kz.techorda.finalTaskNews.models.Comment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    CommentDTO toCommentDto(Comment comment);
    Comment toCommentModel(CommentDTO commentDTO);

    List<CommentDTO> toCommentDtoList(List<Comment> commentList);

    List<Comment> toCommetModelList(List<CommentDTO> commentDTOList);
}
