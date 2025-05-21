package academy.ouaf.dao;

import academy.ouaf.model.LessonCancellationReason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonCancellationReasonDao extends JpaRepository<LessonCancellationReason, Byte> {
}