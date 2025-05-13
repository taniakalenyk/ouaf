package academy.ouaf.controller;

import academy.ouaf.dao.VaccineDao;
import academy.ouaf.model.Vaccine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/vaccines")
public class VaccineController {

    private final VaccineDao vaccineDao;

    @Autowired
    public VaccineController(VaccineDao vaccineDao) {
        this.vaccineDao = vaccineDao;
    }

    @GetMapping
    public ResponseEntity<List<Vaccine>> getAllVaccines() {
        List<Vaccine> vaccines = vaccineDao.findAll();
        return new ResponseEntity<>(vaccines, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vaccine> getVaccineById(@PathVariable Integer id) {
        Vaccine vaccine = vaccineDao.findById(id).orElse(null);
        if (vaccine != null) {
            return new ResponseEntity<>(vaccine, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Vaccine> createVaccine(@RequestBody Vaccine vaccine) {
        Vaccine newVaccine = vaccineDao.save(vaccine);
        return new ResponseEntity<>(newVaccine, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vaccine> updateVaccine(@PathVariable Integer id, @RequestBody Vaccine vaccineDetails) {
        return vaccineDao.findById(id).map(vaccine -> {
            vaccine.setVaccineName(vaccineDetails.getVaccineName());
            return new ResponseEntity<>(vaccineDao.save(vaccine), HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVaccine(@PathVariable Integer id) {
        return vaccineDao.findById(id).map(vaccine -> {
            vaccineDao.delete(vaccine);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}