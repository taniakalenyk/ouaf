package academy.ouaf.dao;

import academy.ouaf.model.Template;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateDao extends JpaRepository<Template, Short> {

}
