package academy.ouaf.dao;

import academy.ouaf.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteDao extends JpaRepository<Quote, Byte> {
}