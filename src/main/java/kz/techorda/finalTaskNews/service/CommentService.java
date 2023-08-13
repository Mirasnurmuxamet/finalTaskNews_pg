package kz.techorda.finalTaskNews.service;

import kz.techorda.finalTaskNews.dto.CommentDTO;
import kz.techorda.finalTaskNews.mapper.CommentMapper;
import kz.techorda.finalTaskNews.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    private final CommentMapper commentMapper;




    public List<CommentDTO> getComments(Long id){
        return commentMapper.toCommentDtoList(commentRepository.findAllByPostIdOrderByCommentTimeDesc(id));

    }

    public CommentDTO addComment(CommentDTO commentDTO){
        return commentMapper.toCommentDto(commentRepository.save(commentMapper.toCommentModel(commentDTO)));
    }

    public void deleteComment(Long id){
        commentRepository.deleteById(id);
    }




}
