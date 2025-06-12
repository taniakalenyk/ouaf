package academy.ouaf.controller;

import academy.ouaf.dao.LessonDao;
import academy.ouaf.model.Lesson;
import academy.ouaf.views.LessonView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/lessons")
@CrossOrigin
public class LessonController {

    private final LessonDao lessonDao;

    @Autowired
    public LessonController(LessonDao lessonDao) {
        this.lessonDao = lessonDao;
    }

    @GetMapping
    @JsonView(LessonView.class)
    public ResponseEntity<List<Lesson>> getAllLessons() {
        List<Lesson> lessons = lessonDao.findAll();
        return new ResponseEntity<>(lessons, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lesson> getLessonById(@PathVariable Long id) {
        Lesson lesson = lessonDao.findById(id).orElse(null);
        if (lesson != null) {
            return new ResponseEntity<>(lesson, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Lesson> createLesson(@RequestBody Lesson lesson) {
        Lesson newLesson = lessonDao.save(lesson);
        return new ResponseEntity<>(newLesson, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lesson> updateLesson(@PathVariable Long id, @RequestBody Lesson lessonDetails) {
        return lessonDao.findById(id).map(lesson -> {
            lesson.setStartDateTime(lessonDetails.getStartDateTime());
            lesson.setEndDateTime(lessonDetails.getEndDateTime());
            lesson.setLocation(lessonDetails.getLocation());
            lesson.setLessonCancellationReason(lessonDetails.getLessonCancellationReason());
            lesson.setCoach(lessonDetails.getCoach());
            lesson.setTemplate(lessonDetails.getTemplate());
            lesson.setEnrollments(lessonDetails.getEnrollments());
            return new ResponseEntity<>(lessonDao.save(lesson), HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLesson(@PathVariable Long id) {
        return lessonDao.findById(id).map(lesson -> {
            lessonDao.delete(lesson);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}