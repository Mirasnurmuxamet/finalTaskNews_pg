package kz.techorda.finalTaskNews.repository;

import jakarta.transaction.Transactional;
import kz.techorda.finalTaskNews.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByPostIdOrderByCommentTimeDesc(Long id);


}
