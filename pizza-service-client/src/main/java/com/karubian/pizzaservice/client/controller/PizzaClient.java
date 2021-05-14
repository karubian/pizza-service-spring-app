package com.karubian.pizzaservice.client.controller;

import com.karubian.pizzaservice.client.model.PizzaDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;

import java.net.URI;
import java.util.UUID;

@ConfigurationProperties(prefix = "brk.pizza",ignoreUnknownFields = false)
@Component
public class PizzaClient {
    public final String PIZZA_PATH_V1 = "/api/v1/pizza/";

    private String apihost;
    private final RestTemplate restTemplate;

    public PizzaClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public PizzaDto getPizzaById(UUID uuid) {
        return restTemplate.getForObject(apihost + PIZZA_PATH_V1 + uuid.toString(),PizzaDto.class);
    }

    public URI saveNewPizza(PizzaDto pizzaDto) {
        return restTemplate.postForLocation(apihost+PIZZA_PATH_V1,pizzaDto);
    }

    public void updatePizza(UUID uuid,PizzaDto pizzaDto) {
        restTemplate.put(apihost + PIZZA_PATH_V1 + uuid,pizzaDto);
    }

    public void deletePizza(UUID uuid) {
        restTemplate.delete(apihost + PIZZA_PATH_V1 + uuid);
    }
    public void setApihost(String apihost) {
        this.apihost = apihost;
    }

}
