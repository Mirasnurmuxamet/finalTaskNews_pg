package kz.techorda.finalTaskNews.repository;

import jakarta.transaction.Transactional;
import kz.techorda.finalTaskNews.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
