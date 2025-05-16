package academy.ouaf.dao.users;

import academy.ouaf.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserDao extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}