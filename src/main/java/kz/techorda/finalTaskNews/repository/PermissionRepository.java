package kz.techorda.finalTaskNews.repository;

import jakarta.transaction.Transactional;
import kz.techorda.finalTaskNews.models.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
@Transactional
public  interface PermissionRepository extends JpaRepository<Permission, Long> {

    Permission findPermissionByRole(String role);


}
