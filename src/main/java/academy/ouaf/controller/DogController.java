package academy.ouaf.controller;

import academy.ouaf.dao.DogDao;
import academy.ouaf.model.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/dogs")
@CrossOrigin
public class DogController {

    private final DogDao dogDao;

    @Autowired
    public DogController(DogDao dogDao) {
        this.dogDao = dogDao;
    }

    @GetMapping
    public ResponseEntity<List<Dog>> getAllDogs() {
        List<Dog> dogs = dogDao.findAll();
        return new ResponseEntity<>(dogs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    // @JsonView(DogView
    public ResponseEntity<Dog> getDogById(@PathVariable Long id) {
        Optional<Dog> optionalDog = dogDao.findById(id);
        if (optionalDog.isPresent()) {
            return new ResponseEntity<>(optionalDog.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Dog> createDog(@RequestBody Dog dog) {
        Dog newDog = dogDao.save(dog);
        return new ResponseEntity<>(newDog, HttpStatus.CREATED);
    }

    // PICTURE

//    @PostMapping
//    public ResponseEntity<Dog> createDog(@RequestBody Dog dog) {
//    @RequestPart("dog") @Valid Dog dog,
//            @RequestPart(value = "photo",required = false) MultipartFile photo,
//                    @AuthenticationPrincipal AppUserDetails userDetails) {
//    userDetails = null;
//        }

//    @Autowired
//    public DogController(DogDao )

//    }


    @PutMapping("/{id}")
    public ResponseEntity<Dog> updateDog(@PathVariable Long id, @RequestBody Dog dogDetails) {
        return dogDao.findById(id).map(dog -> {
            dog.setName(dogDetails.getName());
            dog.setGender(dogDetails.getGender());
            dog.setBirthDate(dogDetails.getBirthDate());
            dog.setPhotoId(dogDetails.getPhotoId());
            dog.setWeight(dogDetails.getWeight());
            dog.setNotes(dogDetails.getNotes());
            dog.setOwner(dogDetails.getOwner());
            dog.setPrimaryBreed(dogDetails.getPrimaryBreed());
//            dog.setSecondaryBreed(dogDetails.getSecondaryBreed());
            dog.setVeterinarian(dogDetails.getVeterinarian());
            dog.setVaccinations(dogDetails.getVaccinations());
            return new ResponseEntity<>(dogDao.save(dog), HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDog(@PathVariable Long id) {
        return dogDao.findById(id).map(dog -> {
            dogDao.delete(dog);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); // 204 No Content
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND)); // 404 Not Found if dog doesn't exist
    }

}