package academy.ouaf.dao.users;

import academy.ouaf.model.Coach;
import academy.ouaf.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoachDao extends JpaRepository<Coach, Long> {
    Optional<Coach> findByEmail(String email);
}