package kz.techorda.finalTaskNews.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_posts")
@Getter
@Setter
public class Post  extends BaseModel{

    @Column(name = "title")
    private String title;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "post_time")
    private String postTime;

    @ManyToOne
    private User user;

    @ManyToOne
    private NewsCategory newsCategory;

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private List<Comment> comments = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        postTime = dateTime.format(formatter);
    }

}
