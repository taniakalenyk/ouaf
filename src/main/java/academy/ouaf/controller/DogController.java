package academy.ouaf.controller;

import academy.ouaf.dao.DogDao;
import academy.ouaf.model.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/dogs")
public class DogController {

    private final DogDao dogDao;

    @Autowired
    public DogController(DogDao dogDao) {
        this.dogDao = dogDao;
    }

    @GetMapping
    public ResponseEntity<List<Dog>> getAllDogs() {
        List<Dog> dogs = dogDao.findAll();
        return new ResponseEntity<>(dogs,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dog> getDogById(@PathVariable Long id) {
            Dog dog = dogDao.findById(id).orElse(null);
            if (dog != null) {
                return new ResponseEntity<>(dog, HttpStatus.OK);
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