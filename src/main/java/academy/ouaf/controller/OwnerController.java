package academy.ouaf.controller;
import academy.ouaf.dao.UserDao;
import academy.ouaf.model.Owner;
import academy.ouaf.model.User;
import academy.ouaf.views.OwnerView;
import com.fasterxml.jackson.annotation.JsonView;
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
@CrossOrigin
public class OwnerController {

    private final UserDao userDao;

    @Autowired
    public OwnerController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping
    @JsonView(OwnerView.class)
    public ResponseEntity<List<User>> getAllOwners() {
        List<User> owners = userDao.findByRole("OWNER");
        return new ResponseEntity<>(owners, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @JsonView(OwnerView.class)
    public ResponseEntity<User> getOwnerById(@PathVariable Long id) {
        Optional<User> optionalUser = userDao.findById(id);

        return optionalUser
                .filter(user -> "OWNER".equals(user.getRole()))
                .map(owner -> new ResponseEntity<>(owner, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<User> createOwner(@RequestBody @Valid Owner owner) {
        owner.setRegistrationDate(LocalDateTime.now());
        return new ResponseEntity<>(userDao.save(owner), HttpStatus.CREATED);
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
    public ResponseEntity<User> updateOwner(@PathVariable Long id, @RequestBody Owner ownerDetails) {
        Optional<User> updatedUser = userDao.findById(id)
                .filter(user -> "OWNER".equals(user.getRole()))
                .map(user -> {
                    user.setFirstName(ownerDetails.getFirstName());
                    user.setLastName(ownerDetails.getLastName());
                    user.setEmail(ownerDetails.getEmail());
                    user.setPassword(ownerDetails.getPassword());
                    user.setPhotoId(ownerDetails.getPhotoId());

                    if (user instanceof Owner owner) {
                        owner.setPhoneNumber(ownerDetails.getPhoneNumber());
                        owner.setAddress(ownerDetails.getAddress());
                        owner.setAbout(ownerDetails.getAbout());
                        owner.setBirthdate(ownerDetails.getBirthdate());
                        owner.setCity(ownerDetails.getCity());
                        owner.setPostcode(ownerDetails.getPostcode());
                    }

                    return user;
                })
                .map(userDao::save);

        return updatedUser
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOwner(@PathVariable Long id) {
        return userDao.findById(id)
                .filter(user -> "OWNER".equals(user.getRole()))
                .map(user -> {
                    userDao.delete(user);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
