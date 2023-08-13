package kz.techorda.finalTaskNews.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "t_comments")
@Getter
@Setter
public class Comment extends BaseModel{

    @Column(name = "comment", columnDefinition = "TEXT")
    private String comment;

    @Column(name = "comment_time")
    private String commentTime;

    @ManyToOne
    private User user;

    @ManyToOne
    private Post post;

    @PrePersist
    public void prePersist() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        commentTime = dateTime.format(formatter);
    }
}
