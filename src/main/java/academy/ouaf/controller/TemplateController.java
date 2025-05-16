package academy.ouaf.controller;

import academy.ouaf.dao.TemplateDao;
import academy.ouaf.model.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/templates")
@CrossOrigin
public class TemplateController {

    private final TemplateDao templateDao;

    @Autowired
    public TemplateController(TemplateDao templateDao) {
        this.templateDao = templateDao;
    }

    @GetMapping
    public ResponseEntity<List<Template>> getAllTemplates() {
        List<Template> templates = templateDao.findAll();
        return new ResponseEntity<>(templates, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Template> getTemplateById(@PathVariable Short id) {
        Template template = templateDao.findById(id).orElse(null);
        if (template != null) {
            return new ResponseEntity<>(template, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Template> createTemplate(@RequestBody Template template) {
        Template newTemplate = templateDao.save(template);
        return new ResponseEntity<>(newTemplate, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Template> updateTemplate(@PathVariable Short id, @RequestBody Template templateDetails) {
        return templateDao.findById(id).map(template -> {
            template.setCapacity(templateDetails.getCapacity());
            template.setPrice(templateDetails.getPrice());
            template.setPriceCorrection(templateDetails.getPriceCorrection());
            template.setType(templateDetails.getType());
            template.setAgeRange(templateDetails.getAgeRange());
            return new ResponseEntity<>(templateDao.save(template), HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTemplate(@PathVariable Short id) {
        return templateDao.findById(id).map(template -> {
            templateDao.delete(template);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}