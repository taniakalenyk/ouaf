package academy.ouaf.dao;

import academy.ouaf.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentDao extends JpaRepository<Enrollment, Long> {
}