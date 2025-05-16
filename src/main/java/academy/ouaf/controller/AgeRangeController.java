package academy.ouaf.controller;

import academy.ouaf.dao.AgeRangeDao;
import academy.ouaf.model.AgeRange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/age-ranges")
@CrossOrigin
public class AgeRangeController {

    private final AgeRangeDao ageRangeDao;

    @Autowired
    public AgeRangeController(AgeRangeDao ageRangeDao) {
        this.ageRangeDao = ageRangeDao;
    }

    @GetMapping
    public ResponseEntity<List<AgeRange>> getAllAgeRanges() {
        List<AgeRange> ageRanges = ageRangeDao.findAll();
        return new ResponseEntity<>(ageRanges, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgeRange> getAgeRangeById(@PathVariable Byte id) {
        AgeRange ageRange = ageRangeDao.findById(id).orElse(null);
        if (ageRange != null) {
            return new ResponseEntity<>(ageRange, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<AgeRange> createAgeRange(@RequestBody AgeRange ageRange) {
        AgeRange newAgeRange = ageRangeDao.save(ageRange);
        return new ResponseEntity<>(newAgeRange, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgeRange> updateAgeRange(@PathVariable Byte id, @RequestBody AgeRange ageRangeDetails) {
        return ageRangeDao.findById(id).map(ageRange -> {
            ageRange.setAgeMin(ageRangeDetails.getAgeMin());
            ageRange.setAgeMax(ageRangeDetails.getAgeMax());
            return new ResponseEntity<>(ageRangeDao.save(ageRange), HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgeRange(@PathVariable Byte id) {
        return ageRangeDao.findById(id).map(ageRange -> {
            ageRangeDao.delete(ageRange);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}