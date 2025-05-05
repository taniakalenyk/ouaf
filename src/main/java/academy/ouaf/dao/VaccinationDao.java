package academy.ouaf.dao;

import academy.ouaf.model.Vaccination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinationDao extends JpaRepository<Vaccination, Long> {
}