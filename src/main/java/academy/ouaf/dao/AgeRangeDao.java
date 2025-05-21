package academy.ouaf.dao;

import academy.ouaf.model.AgeRange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgeRangeDao extends JpaRepository<AgeRange, Byte> {
}