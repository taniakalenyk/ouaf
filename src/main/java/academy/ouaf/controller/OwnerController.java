package academy.ouaf.controller;

import academy.ouaf.dao.OwnerDao;
import academy.ouaf.model.Owner;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/owners")
public class OwnerController {

    private final OwnerDao ownerDao;

    @Autowired
    public OwnerController(OwnerDao ownerDao) {
        this.ownerDao = ownerDao;
    }

    @GetMapping
    public ResponseEntity<List<Owner>> getAllOwners() {
        List<Owner> owners = ownerDao.findAll();
        return new ResponseEntity<>(owners, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Owner> getOwnerById(@PathVariable Long id) {
        Optional<Owner> owner = ownerDao.findById(id);
        return owner.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Owner> createOwner(@RequestBody @Valid Owner owner) {
        owner.setRegistrationDate(LocalDateTime.now());
        Owner newOwner = ownerDao.save(owner);
        return new ResponseEntity<>(newOwner, HttpStatus.CREATED);
    }



//    @PostMapping
//    public ResponseEntity<Owner> addOwner(@RequestBody Owner owner) {
//        user.setId(null);
//        user.setUserRole(UserRole.COACH);
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//
//        userDao.save(user);
//
//        // Hiding the password before sending the response
//        user.setPassword(null);
//
//        return new ResponseEntity<>(user, HttpStatus.CREATED);
//    }


    @PutMapping("/{id}")
    public ResponseEntity<Owner> updateOwner(@PathVariable Long id, @RequestBody Owner ownerDetails) {
        Optional<Owner> optionalOwner = ownerDao.findById(id);
        if (optionalOwner.isPresent()) {
            Owner owner = optionalOwner.get();
            owner.setFirstName(ownerDetails.getFirstName());
            owner.setLastName(ownerDetails.getLastName());
            owner.setEmail(ownerDetails.getEmail());
            owner.setPassword(ownerDetails.getPassword());
            owner.setPhotoId(ownerDetails.getPhotoId());
            
            Owner updatedOwner = ownerDao.save(owner);
            return new ResponseEntity<>(updatedOwner, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOwner(@PathVariable Long id) {
        Optional<Owner> owner = ownerDao.findById(id);
        if (owner.isPresent()) {
            ownerDao.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}