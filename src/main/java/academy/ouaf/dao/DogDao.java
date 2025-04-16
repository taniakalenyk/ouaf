package academy.ouaf.dao;

import academy.ouaf.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogDao extends JpaRepository<Dog, Long> {

}
