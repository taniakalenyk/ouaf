package academy.ouaf.dao.users;

import academy.ouaf.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OwnerDao extends JpaRepository<Owner, Long> {
    Optional<Owner> findByEmail(String email);
}