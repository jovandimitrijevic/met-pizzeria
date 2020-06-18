package rs.ac.metropolitan.cs330.pz.metpizzeria.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.metropolitan.cs330.pz.metpizzeria.entities.Pizza;
import rs.ac.metropolitan.cs330.pz.metpizzeria.repositories.PizzaRepository;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/pizza", produces = MediaType.APPLICATION_JSON_VALUE)
public class PizzaRESTController {

    private PizzaRepository pizzaRepository;

    @Autowired
    public PizzaRESTController(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    @GetMapping
    public ResponseEntity<List<Pizza>> getPizzas() {
        List<Pizza> pizzas = pizzaRepository.findAll();

        if (pizzas.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(pizzas, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Pizza> getPizza(@PathVariable("id") long id) {
        Optional<Pizza> pizza = pizzaRepository.findById(id);
        if (!pizza.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(pizza.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addPizza(@RequestBody Pizza pizza) {
        pizzaRepository.saveAndFlush(pizza);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

}

