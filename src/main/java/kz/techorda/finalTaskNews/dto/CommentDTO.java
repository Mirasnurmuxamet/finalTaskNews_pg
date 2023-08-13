package kz.techorda.finalTaskNews.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class CommentDTO {
    private  Long id;
    private String comment;
    private String commentTime;
    private UserDTO user;
    private PostDTO post;
}
