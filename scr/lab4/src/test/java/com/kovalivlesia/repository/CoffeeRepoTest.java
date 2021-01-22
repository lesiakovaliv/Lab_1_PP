package com.kovalivlesia.repository;

import com.kovalivlesia.RepoBasedTest;
import com.kovalivlesia.models.Coffee;
import com.kovalivlesia.models.CoffeeType;
import lombok.extern.java.Log;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@Log
public class CoffeeRepoTest extends RepoBasedTest {
    static List<Coffee> coffees = new ArrayList<>();
    CoffeeRepo coffeeRepo = new CoffeeRepo();

    @BeforeClass
    public static void before() {
        coffees.add(new Coffee(0, "Coffee_1", CoffeeType.GRAIN));
        coffees.add(new Coffee(1, "Coffee_2", CoffeeType.INSTANT));
        coffees.add(new Coffee(2, "Coffee_3", CoffeeType.GROUND));

        log.info("Coffees - " + coffees);
        assertEquals(3, coffees.size());
        log.info("Before ended");
    }

    @Test
    public void mainTest() {
        coffeeRepo.add(coffees.get(0));

        assertEquals(coffeeRepo.getAll().get(0).getId(), coffees.get(0).getId());
        assertEquals(coffeeRepo.getAll().get(0).getType(), coffees.get(0).getType());
        assertEquals(coffeeRepo.getAll().get(0).getName(), coffees.get(0).getName());

        coffeeRepo.delete(coffees.get(0));

        assertEquals(coffeeRepo.getAll().size(), 0);
    }
}
