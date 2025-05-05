package academy.ouaf.dao;

import academy.ouaf.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerDao extends JpaRepository<Owner, Long> {
}