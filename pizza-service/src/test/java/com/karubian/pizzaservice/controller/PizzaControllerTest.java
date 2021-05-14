package com.karubian.pizzaservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.karubian.pizzaservice.model.PizzaDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@WebMvcTest(PizzaController.class)
class PizzaControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getPizzaById() throws Exception {
        mockMvc.perform(get("/api/v1/pizza/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    void saveNewPizza() throws Exception {
        PizzaDto pizzaDto = PizzaDto.builder().build();
        String pizzaDtoJson = objectMapper.writeValueAsString(pizzaDto);

        mockMvc.perform(post("/api/v1/pizza/").contentType(MediaType.APPLICATION_JSON).content(pizzaDtoJson)).andExpect(status().isCreated());
    }

    @Test
    void updatePizzaById() throws  Exception{
        PizzaDto pizzaDto = PizzaDto.builder().build();
        String pizzaDtoJson = objectMapper.writeValueAsString(pizzaDto);

        mockMvc.perform(put(("/api/v1/pizza/"+UUID.randomUUID().toString())).contentType(MediaType.APPLICATION_JSON).content(pizzaDtoJson)).andExpect(status().isNoContent());
    }
}