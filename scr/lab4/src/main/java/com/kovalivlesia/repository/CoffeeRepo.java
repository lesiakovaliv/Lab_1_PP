package com.kovalivlesia.repository;

import com.kovalivlesia.models.Coffee;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;

@Log
public class CoffeeRepo implements Repository<Coffee> {

    private List<Coffee> coffees = new ArrayList<>();

    @Override
    public List<Coffee> getAll() {
        return coffees;
    }

    @Override
    public Coffee add(Coffee object) {
        coffees.add(object);
        log.info("Added " + object.toString() + " coffee");
        return object;
    }

    @Override
    public void delete(Coffee object) {
        coffees.remove(object);
        log.info("Removed " + object.toString() + " coffee");
    }
}
