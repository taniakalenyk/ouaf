package academy.ouaf.controller;

import academy.ouaf.dao.VeterinarianDao;
import academy.ouaf.model.Veterinarian;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/veterinarians")
public class VeterinarianController {

    private final VeterinarianDao veterinarianDao;

    @Autowired
    public VeterinarianController(VeterinarianDao veterinarianDao) {
        this.veterinarianDao = veterinarianDao;
    }

    @GetMapping
    public ResponseEntity<List<Veterinarian>> getAllVeterinarians() {
        List<Veterinarian> veterinarians = veterinarianDao.findAll();
        return new ResponseEntity<>(veterinarians, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veterinarian> getVeterinarianById(@PathVariable Integer id) {
        Veterinarian veterinarian = veterinarianDao.findById(id).orElse(null);
        if (veterinarian != null) {
            return new ResponseEntity<>(veterinarian, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Veterinarian> createVeterinarian(@RequestBody Veterinarian veterinarian) {
        Veterinarian newVeterinarian = veterinarianDao.save(veterinarian);
        return new ResponseEntity<>(newVeterinarian, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veterinarian> updateVeterinarian(@PathVariable Integer id, @RequestBody Veterinarian veterinarianDetails) {
        return veterinarianDao.findById(id).map(veterinarian -> {
            veterinarian.setFirstName(veterinarianDetails.getFirstName());
            veterinarian.setLastName(veterinarianDetails.getLastName());
            veterinarian.setPhoneNumber(veterinarianDetails.getPhoneNumber());
            veterinarian.setEmail(veterinarianDetails.getEmail());
            veterinarian.setClinicName(veterinarianDetails.getClinicName());
            veterinarian.setClinicAddress(veterinarianDetails.getClinicAddress());
            veterinarian.setClinicCity(veterinarianDetails.getClinicCity());
            veterinarian.setClinicPostcode(veterinarianDetails.getClinicPostcode());
            return new ResponseEntity<>(veterinarianDao.save(veterinarian), HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVeterinarian(@PathVariable Integer id) {
        return veterinarianDao.findById(id).map(veterinarian -> {
            veterinarianDao.delete(veterinarian);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}