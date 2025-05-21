package academy.ouaf.controller;

import academy.ouaf.dao.BreedDao;
import academy.ouaf.model.Breed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/breeds")
@CrossOrigin
public class BreedController {

    private final BreedDao breedDao;

    @Autowired
    public BreedController(BreedDao breedDao) {
        this.breedDao = breedDao;
    }

    @GetMapping
    public ResponseEntity<List<Breed>> getAllBreeds() {
        List<Breed> breeds = breedDao.findAll();
        return new ResponseEntity<>(breeds, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Breed> getBreedById(@PathVariable Short id) {
        Breed breed = breedDao.findById(id).orElse(null);
        if (breed != null) {
            return new ResponseEntity<>(breed, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}