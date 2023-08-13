package kz.techorda.finalTaskNews.repository;

import jakarta.transaction.Transactional;
import kz.techorda.finalTaskNews.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface PostRepository extends JpaRepository<Post, Long> {


    List<Post>  findTop50ByOrderByPostTimeDesc();

    List<Post>  findTop50ByNewsCategory_NameOrderByPostTimeDesc(String newsCategory);
    List<Post>  findTop50ByNewsCategoryIdOrderByPostTimeDesc(Long id);


    List<Post> findAllByUserIdOrderByPostTimeDesc(Long userId);



}
