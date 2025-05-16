package academy.ouaf.dao.users;

import academy.ouaf.model.Admin;
import academy.ouaf.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminDao extends JpaRepository<Admin, Long> {
    Optional<Admin> findByEmail(String email);
}