package academy.ouaf.controller;

import academy.ouaf.dao.VaccinationDao;
import academy.ouaf.model.Vaccination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/vaccinations")
@CrossOrigin
public class VaccinationController {

    private final VaccinationDao vaccinationDao;

    @Autowired
    public VaccinationController(VaccinationDao vaccinationDao) {
        this.vaccinationDao = vaccinationDao;
    }

    @GetMapping
    public ResponseEntity<List<Vaccination>> getAllVaccinations() {
        List<Vaccination> vaccinations = vaccinationDao.findAll();
        return new ResponseEntity<>(vaccinations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vaccination> getVaccinationById(@PathVariable Long id) {
        Vaccination vaccination = vaccinationDao.findById(id).orElse(null);
        if (vaccination != null) {
            return new ResponseEntity<>(vaccination, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Vaccination> createVaccination(@RequestBody Vaccination vaccination) {
        Vaccination newVaccination = vaccinationDao.save(vaccination);
        return new ResponseEntity<>(newVaccination, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vaccination> updateVaccination(@PathVariable Long id, @RequestBody Vaccination vaccinationDetails) {
        return vaccinationDao.findById(id).map(vaccination -> {
            vaccination.setFirstVaccinationDate(vaccinationDetails.getFirstVaccinationDate());
            vaccination.setBoosterDate(vaccinationDetails.getBoosterDate());
            vaccination.setVaccine(vaccinationDetails.getVaccine());
            vaccination.setDog(vaccinationDetails.getDog());
            return new ResponseEntity<>(vaccinationDao.save(vaccination), HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVaccination(@PathVariable Long id) {
        return vaccinationDao.findById(id).map(vaccination -> {
            vaccinationDao.delete(vaccination);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}