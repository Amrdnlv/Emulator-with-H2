package com.thecheckler.sburrestdemo.classs;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/coffes")
public class ResstApiDemoController {
    private final Cofferepository cofferepository;

    public ResstApiDemoController(Cofferepository cofferepository)
    {
        this.cofferepository = cofferepository;
        this.cofferepository.saveAll(List.of(
          new Coffee("Cafe Cereza"),
          new Coffee("Cafe Ganadoz"),
          new Coffee("Cafe Lareno"),
          new Coffee("Cafe Tres Pontas")
        ));
    }

    @GetMapping
    Iterable<Coffee> getCofees()
    {
        return cofferepository.findAll();
    }

    @GetMapping("/{id}")
    ResponseEntity getCofeesById(@PathVariable String id)
    {
        return new ResponseEntity(cofferepository.findById(id),HttpStatus.FAILED_DEPENDENCY);
    }

//    для получения списка видов кофе
    @PostMapping
    Coffee postCoffee(@RequestBody Coffee coffee) {

        return cofferepository.save(coffee);
    }
    @PutMapping("/{id}")
    ResponseEntity putCoffee(@PathVariable String id, @RequestBody Coffee coffee) {
        return (!cofferepository.existsById(id))?
                new ResponseEntity<>(cofferepository.save(coffee), HttpStatus.CREATED)
        : new ResponseEntity<>(cofferepository.save(coffee), HttpStatus.OK);

    }
    @DeleteMapping("{id}")
    ResponseEntity deleteCoffee(@PathVariable String id) {
        cofferepository.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
