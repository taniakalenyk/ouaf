package academy.ouaf.controller;

import academy.ouaf.dao.UserDao;
import academy.ouaf.model.Coach;
import academy.ouaf.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/coaches")
@CrossOrigin
public class CoachController {

    private final UserDao userDao;

    @Autowired
    public CoachController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllCoaches() {
        List<User> coaches = userDao.findByRole("COACH");
        return new ResponseEntity<>(coaches, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getCoachById(@PathVariable Long id) {
        return userDao.findById(id)
                .filter(user -> "COACH".equals(user.getRole()))
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<User> createCoach(@RequestBody Coach coach) {
        return new ResponseEntity<>(userDao.save(coach), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateCoach(@PathVariable Long id, @RequestBody Coach coachDetails) {
        return userDao.findById(id)
                .filter(user -> "COACH".equals(user.getRole()))
                .map(user -> {
                    user.setFirstName(coachDetails.getFirstName());
                    user.setLastName(coachDetails.getLastName());
                    user.setEmail(coachDetails.getEmail());
                    user.setPassword(coachDetails.getPassword());
                    user.setPhotoId(coachDetails.getPhotoId());

                    if (user instanceof Coach coach) {
                        coach.setPhoneNumber(coachDetails.getPhoneNumber());
                        coach.setType(coachDetails.getType());
                    }

                    return new ResponseEntity<>(userDao.save(user), HttpStatus.OK);
                }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoach(@PathVariable Long id) {
        return userDao.findById(id)
                .filter(user -> "COACH".equals(user.getRole()))
                .map(user -> {
                    userDao.delete(user);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
