package academy.ouaf.dao;

import academy.ouaf.model.EnrollmentCancellationReason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentCancellationReasonDao extends JpaRepository<EnrollmentCancellationReason, Byte> {
}