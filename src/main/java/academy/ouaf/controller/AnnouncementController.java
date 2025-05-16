package academy.ouaf.controller;

import academy.ouaf.dao.AnnouncementDao;
import academy.ouaf.model.Announcement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/announcements")
@CrossOrigin
public class AnnouncementController {

    private final AnnouncementDao announcementDao;

    @Autowired
    public AnnouncementController(AnnouncementDao announcementDao) {
        this.announcementDao = announcementDao;
    }

    @GetMapping
    public ResponseEntity<List<Announcement>> getAllAnnouncements() {
        List<Announcement> announcements = announcementDao.findAll();
        return new ResponseEntity<>(announcements, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Announcement> getAnnouncementById(@PathVariable Byte id) {
        Announcement announcement = announcementDao.findById(id).orElse(null);
        if (announcement != null) {
            return new ResponseEntity<>(announcement, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Announcement> createAnnouncement(@RequestBody Announcement announcement) {
        Announcement newAnnouncement = announcementDao.save(announcement);
        return new ResponseEntity<>(newAnnouncement, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Announcement> updateAnnouncement(@PathVariable Byte id, @RequestBody Announcement announcementDetails) {
        return announcementDao.findById(id).map(announcement -> {
            announcement.setStartDateTime(announcementDetails.getStartDateTime());
            announcement.setEndDateTime(announcementDetails.getEndDateTime());
            announcement.setAnnouncementText(announcementDetails.getAnnouncementText());
            return new ResponseEntity<>(announcementDao.save(announcement), HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnnouncement(@PathVariable Byte id) {
        return announcementDao.findById(id).map(announcement -> {
            announcementDao.delete(announcement);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}