package academy.ouaf.dao;

import academy.ouaf.model.Veterinarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinarianDao extends JpaRepository<Veterinarian, Integer> {
}