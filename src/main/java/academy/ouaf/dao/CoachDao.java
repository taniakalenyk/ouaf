package academy.ouaf.dao;

import academy.ouaf.model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachDao extends JpaRepository<Coach, Long> {
}