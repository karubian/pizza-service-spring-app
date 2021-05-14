package com.karubian.pizzaservice.model;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class PizzaPagedList extends PageImpl<PizzaDto> {
    public PizzaPagedList(List<PizzaDto> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public PizzaPagedList(List<PizzaDto> content) {
        super(content);
    }
}
