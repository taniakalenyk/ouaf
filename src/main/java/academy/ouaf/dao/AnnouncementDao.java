package academy.ouaf.dao;

import academy.ouaf.model.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementDao extends JpaRepository<Announcement, Byte> {
}