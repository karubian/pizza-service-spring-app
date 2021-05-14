package com.karubian.pizzaservice.controller;

import com.karubian.pizzaservice.model.PizzaDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/pizza")
@RestController
public class PizzaController {
    @GetMapping("/{pizzaId}")
    public ResponseEntity<PizzaDto> getPizzaById(@PathVariable("pizzaId") UUID pizzaId){
        //todo impl

        return new ResponseEntity<>(PizzaDto.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewPizza(@RequestBody PizzaDto pizzaDto) {

        //todo impl
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{pizzaId}")
    public ResponseEntity updatePizzaById(@PathVariable("pizzaId") UUID pizzaId,@RequestBody PizzaDto pizzaDto)
    {
        //todo impl
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{pizzaId}")
    public ResponseEntity deletePizzaById(@PathVariable("pizzaId") UUID pizzaId)
    {
        //todo impl
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
