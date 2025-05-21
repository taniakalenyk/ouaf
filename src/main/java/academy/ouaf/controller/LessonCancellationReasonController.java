package academy.ouaf.controller;

import academy.ouaf.dao.LessonCancellationReasonDao;
import academy.ouaf.model.LessonCancellationReason;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/lesson-cancellation-reasons")
@CrossOrigin
public class LessonCancellationReasonController {

    private final LessonCancellationReasonDao lessonCancellationReasonDao;

    @Autowired
    public LessonCancellationReasonController(LessonCancellationReasonDao lessonCancellationReasonDao) {
        this.lessonCancellationReasonDao = lessonCancellationReasonDao;
    }

    @GetMapping
    public ResponseEntity<List<LessonCancellationReason>> getAllLessonCancellationReasons() {
        List<LessonCancellationReason> reasons = lessonCancellationReasonDao.findAll();
        return new ResponseEntity<>(reasons, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LessonCancellationReason> getLessonCancellationReasonById(@PathVariable Byte id) {
        LessonCancellationReason reason = lessonCancellationReasonDao.findById(id).orElse(null);
        if (reason != null) {
            return new ResponseEntity<>(reason, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<LessonCancellationReason> createLessonCancellationReason(@RequestBody LessonCancellationReason reason) {
        LessonCancellationReason newReason = lessonCancellationReasonDao.save(reason);
        return new ResponseEntity<>(newReason, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LessonCancellationReason> updateLessonCancellationReason(@PathVariable Byte id, @RequestBody LessonCancellationReason reasonDetails) {
        return lessonCancellationReasonDao.findById(id).map(reason -> {
            reason.setReason(reasonDetails.getReason());
            return new ResponseEntity<>(lessonCancellationReasonDao.save(reason), HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLessonCancellationReason(@PathVariable Byte id) {
        return lessonCancellationReasonDao.findById(id).map(reason -> {
            lessonCancellationReasonDao.delete(reason);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}