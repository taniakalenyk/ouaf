package academy.ouaf.controller;

import academy.ouaf.dao.EnrollmentCancellationReasonDao;
import academy.ouaf.model.EnrollmentCancellationReason;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/enrollment-cancellation-reasons")
public class EnrollmentCancellationReasonController {

    private final EnrollmentCancellationReasonDao enrollmentCancellationReasonDao;

    @Autowired
    public EnrollmentCancellationReasonController(EnrollmentCancellationReasonDao enrollmentCancellationReasonDao) {
        this.enrollmentCancellationReasonDao = enrollmentCancellationReasonDao;
    }

    @GetMapping
    public ResponseEntity<List<EnrollmentCancellationReason>> getAllEnrollmentCancellationReasons() {
        List<EnrollmentCancellationReason> reasons = enrollmentCancellationReasonDao.findAll();
        return new ResponseEntity<>(reasons, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentCancellationReason> getEnrollmentCancellationReasonById(@PathVariable Byte id) {
        EnrollmentCancellationReason reason = enrollmentCancellationReasonDao.findById(id).orElse(null);
        if (reason != null) {
            return new ResponseEntity<>(reason, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<EnrollmentCancellationReason> createEnrollmentCancellationReason(@RequestBody EnrollmentCancellationReason reason) {
        EnrollmentCancellationReason newReason = enrollmentCancellationReasonDao.save(reason);
        return new ResponseEntity<>(newReason, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnrollmentCancellationReason> updateEnrollmentCancellationReason(@PathVariable Byte id, @RequestBody EnrollmentCancellationReason reasonDetails) {
        return enrollmentCancellationReasonDao.findById(id).map(reason -> {
            reason.setReason(reasonDetails.getReason());
            return new ResponseEntity<>(enrollmentCancellationReasonDao.save(reason), HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnrollmentCancellationReason(@PathVariable Byte id) {
        return enrollmentCancellationReasonDao.findById(id).map(reason -> {
            enrollmentCancellationReasonDao.delete(reason);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}