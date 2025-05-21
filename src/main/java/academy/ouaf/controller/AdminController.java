package academy.ouaf.controller;

import academy.ouaf.dao.UserDao;
import academy.ouaf.model.Admin;
import academy.ouaf.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
@CrossOrigin
public class AdminController {

    private final UserDao userDao;

    @Autowired
    public AdminController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllAdmins() {
        List<User> admins = userDao.findByRole("ADMIN");
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getAdminById(@PathVariable Long id) {
        return userDao.findById(id)
                .filter(user -> "ADMIN".equals(user.getRole()))
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<User> createAdmin(@RequestBody Admin admin) {
        return new ResponseEntity<>(userDao.save(admin), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateAdmin(@PathVariable Long id, @RequestBody Admin adminDetails) {
        Optional<User> updatedUser = userDao.findById(id)
                .filter(user -> "ADMIN".equals(user.getRole()))
                .map(user -> {
                    user.setFirstName(adminDetails.getFirstName());
                    user.setLastName(adminDetails.getLastName());
                    user.setEmail(adminDetails.getEmail());
                    user.setPassword(adminDetails.getPassword());
                    user.setPhotoId(adminDetails.getPhotoId());
                    return user;
                })
                .map(userDao::save);

        return updatedUser
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
        return userDao.findById(id)
                .filter(user -> "ADMIN".equals(user.getRole()))
                .map(user -> {
                    userDao.delete(user);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
