package academy.ouaf.dao;

import academy.ouaf.model.Breed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BreedDao extends JpaRepository<Breed, Short> {
}
