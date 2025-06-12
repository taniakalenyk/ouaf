package academy.ouaf.controller;

import academy.ouaf.dao.EnrollmentDao;
import academy.ouaf.model.Enrollment;
import academy.ouaf.views.DogView;
import academy.ouaf.views.EnrollmentView;
import academy.ouaf.views.OwnerView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/enrollments")
@CrossOrigin
public class EnrollmentController {

    private final EnrollmentDao enrollmentDao;

    @Autowired
    public EnrollmentController(EnrollmentDao enrollmentDao) {
        this.enrollmentDao = enrollmentDao;
    }

    @JsonView({EnrollmentView.class})
    @GetMapping
    public ResponseEntity<List<Enrollment>> getAllEnrollments() {
        List<Enrollment> enrollments = enrollmentDao.findAll();
        return new ResponseEntity<>(enrollments, HttpStatus.OK);
    }

    @JsonView({EnrollmentView.class})
    @GetMapping("/{id}")
    public ResponseEntity<Enrollment> getEnrollmentById(@PathVariable Long id) {
        Enrollment enrollment = enrollmentDao.findById(id).orElse(null);
        if (enrollment != null) {
            return new ResponseEntity<>(enrollment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Enrollment> createEnrollment(@RequestBody Enrollment enrollment) {
        Enrollment newEnrollment = enrollmentDao.save(enrollment);
        return new ResponseEntity<>(newEnrollment, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Enrollment> updateEnrollment(@PathVariable Long id, @RequestBody Enrollment enrollmentDetails) {
        return enrollmentDao.findById(id).map(enrollment -> {
            enrollment.setDateCreation(enrollmentDetails.getDateCreation());
            enrollment.setPaymentDate(enrollmentDetails.getPaymentDate());
            enrollment.setDog(enrollmentDetails.getDog());
            enrollment.setLesson(enrollmentDetails.getLesson());
            enrollment.setEnrollmentCancellationReason(enrollmentDetails.getEnrollmentCancellationReason());
            enrollment.setAdmin(enrollmentDetails.getAdmin());
            return new ResponseEntity<>(enrollmentDao.save(enrollment), HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnrollment(@PathVariable Long id) {
        return enrollmentDao.findById(id).map(enrollment -> {
            enrollmentDao.delete(enrollment);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}