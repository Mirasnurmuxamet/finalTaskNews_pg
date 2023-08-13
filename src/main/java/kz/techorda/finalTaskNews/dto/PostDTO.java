package kz.techorda.finalTaskNews.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;


@Getter
@Setter
public class PostDTO {
    private Long id;
    private String title;
    private String content;
    private String postTime;
    private UserDTO user;
    private NewsCategoryDTO newsCategory;

}
