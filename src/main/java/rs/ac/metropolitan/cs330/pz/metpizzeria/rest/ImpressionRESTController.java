package rs.ac.metropolitan.cs330.pz.metpizzeria.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.metropolitan.cs330.pz.metpizzeria.entities.Impression;
import rs.ac.metropolitan.cs330.pz.metpizzeria.repositories.ImpressionRepository;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/impression", produces = MediaType.APPLICATION_JSON_VALUE)
public class ImpressionRESTController {

    private ImpressionRepository impressionRepository;

    @Autowired
    public ImpressionRESTController(ImpressionRepository impressionRepository) {
        this.impressionRepository = impressionRepository;
    }

    @GetMapping
    public ResponseEntity<List<Impression>> getImpressions() {
        List<Impression> impressions = impressionRepository.findAll();

        if (impressions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(impressions, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Impression> getImpression(@PathVariable long id) {
        Optional<Impression> impression = impressionRepository.findById(id);

        if (!impression.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(impression.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addImpression(@RequestBody Impression impression) {
        impressionRepository.saveAndFlush(impression);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Impression> updateImpression(@PathVariable("id") long id, @RequestBody Impression impression) {
        impression.setImpression_id(id);
        impressionRepository.saveAndFlush(impression);
        return new ResponseEntity<>(impression, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Impression> deleteImpression(@PathVariable("id") long id) {
        Optional<Impression> impression = impressionRepository.findById(id);

        if (!impression.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        impressionRepository.delete(impression.get());
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
