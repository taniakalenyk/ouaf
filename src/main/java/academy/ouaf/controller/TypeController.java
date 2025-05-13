package academy.ouaf.controller;

import academy.ouaf.dao.TypeDao;
import academy.ouaf.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/types")
public class TypeController {

    private final TypeDao typeDao;

    @Autowired
    public TypeController(TypeDao typeDao) {
        this.typeDao = typeDao;
    }

    @GetMapping
    public ResponseEntity<List<Type>> getAllTypes() {
        List<Type> types = typeDao.findAll();
        return new ResponseEntity<>(types, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Type> getTypeById(@PathVariable Byte id) {
        Type type = typeDao.findById(id).orElse(null);
        if (type != null) {
            return new ResponseEntity<>(type, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Type> createType(@RequestBody Type type) {
        Type newType = typeDao.save(type);
        return new ResponseEntity<>(newType, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Type> updateType(@PathVariable Byte id, @RequestBody Type typeDetails) {
        return typeDao.findById(id).map(type -> {
            type.setTypeAppointment(typeDetails.getTypeAppointment());
            return new ResponseEntity<>(typeDao.save(type), HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteType(@PathVariable Byte id) {
        return typeDao.findById(id).map(type -> {
            typeDao.delete(type);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}