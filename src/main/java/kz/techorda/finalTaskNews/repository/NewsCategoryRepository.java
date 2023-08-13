package kz.techorda.finalTaskNews.repository;

import jakarta.transaction.Transactional;

import kz.techorda.finalTaskNews.models.NewsCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface NewsCategoryRepository extends JpaRepository<NewsCategory, Long> {


}
