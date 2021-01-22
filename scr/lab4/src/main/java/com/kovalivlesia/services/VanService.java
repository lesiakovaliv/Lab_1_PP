package com.kovalivlesia.services;

import com.kovalivlesia.models.CoffeePack;
import com.kovalivlesia.models.Van;
import lombok.extern.java.Log;

import java.util.*;
import java.util.stream.Collectors;

@Log
public class VanService {

    public Van sort(Van van) {
        List<Map.Entry<CoffeePack, Integer>> coffees = van.getCoffees().entrySet().stream()
                .sorted(
                        Comparator.comparing(
                                coffeePack ->
                                        coffeePack.getKey().getPrice() / coffeePack.getKey().getPack().getVolumeOfContent()
                        )
                )
                .collect(Collectors.toList());

        Map<CoffeePack, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<CoffeePack, Integer> coffeePack : coffees) {
            result.put(coffeePack.getKey(), coffeePack.getValue());
        }

        log.info("Sorted - " + result);

        return Van.builder()
                .coffees(result)
                .build();
    }

    public List<CoffeePack> find(Van van, Double price, Double volume) {
        List<CoffeePack> result = new ArrayList<>();
        for (CoffeePack coffeePack : van.getCoffees().keySet()) {
            if ((price != null && coffeePack.getPrice() > price)
                    || (volume != null && volume <= coffeePack.getPack().getVolumeOfContent())) {
                continue;
            }
            result.add(coffeePack);
        }

        log.info("Found - " + result);
        return result;
    }

    public void printVans(List<Van> vans) {
        int i = 1;

        for (Van van : vans) {
            System.out.println(i++ + " - " + van.toString());
        }
    }
}
