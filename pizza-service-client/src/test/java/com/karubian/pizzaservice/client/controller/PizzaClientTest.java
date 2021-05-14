package com.karubian.pizzaservice.client.controller;

import com.karubian.pizzaservice.client.model.PizzaDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PizzaClientTest {

    @Autowired
    PizzaClient client;

    @Test
    void getPizzaById() {
        PizzaDto dto = client.getPizzaById(UUID.randomUUID());

        assertNotNull(dto);
    }

    @Test
    void saveNewPizza() {
//        PizzaDto pizzaDto = PizzaDto.builder().pizzaName("New Pizza").build();
//
//        URI uri = client.saveNewPizza(pizzaDto);
//
//        assertNotNull(uri);
//
//        System.out.println(uri.toString());
    }

    @Test
    void updatePizza() {
        PizzaDto pizzaDto = PizzaDto.builder().pizzaName("New Pizza").build();

        client.updatePizza(UUID.randomUUID(),pizzaDto);
    }

    @Test
    void deletePizza() {

        client.deletePizza(UUID.randomUUID());
    }
}