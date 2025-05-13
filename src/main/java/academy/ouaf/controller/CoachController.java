package academy.ouaf.controller;

import academy.ouaf.dao.CoachDao;
import academy.ouaf.model.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/coaches")
public class CoachController {

    private final CoachDao coachDao;

    @Autowired
    public CoachController(CoachDao coachDao) {
        this.coachDao = coachDao;
    }

    @GetMapping
    public ResponseEntity<List<Coach>> getAllCoaches() {
        List<Coach> coaches = coachDao.findAll();
        return new ResponseEntity<>(coaches, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coach> getCoachById(@PathVariable Long id) {
        Coach coach = coachDao.findById(id).orElse(null);
        if (coach != null) {
            return new ResponseEntity<>(coach, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Coach> createCoach(@RequestBody Coach coach) {
        Coach newCoach = coachDao.save(coach);
        return new ResponseEntity<>(newCoach, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coach> updateCoach(@PathVariable Long id, @RequestBody Coach coachDetails) {
        return coachDao.findById(id).map(coach -> {
            // Update User properties
            coach.setFirstName(coachDetails.getFirstName());
            coach.setLastName(coachDetails.getLastName());
            coach.setEmail(coachDetails.getEmail());
            coach.setPassword(coachDetails.getPassword());
            coach.setPhotoId(coachDetails.getPhotoId());
            
            // Update Coach-specific properties
            coach.setPhoneNumber(coachDetails.getPhoneNumber());
            coach.setType(coachDetails.getType());
            
            return new ResponseEntity<>(coachDao.save(coach), HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoach(@PathVariable Long id) {
        return coachDao.findById(id).map(coach -> {
            coachDao.delete(coach);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}