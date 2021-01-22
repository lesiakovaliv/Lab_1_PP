package com.kovalivlesia.repository;

import com.kovalivlesia.models.Van;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;

@Log
public class VanRepo implements Repository<Van> {

    private List<Van> vans = new ArrayList<>();

    @Override
    public List<Van> getAll() {
        return vans;
    }

    @Override
    public Van add(Van object) {
        vans.add(object);
        log.info("Added " + object.toString() + " van");
        return object;
    }

    @Override
    public void delete(Van object) {
        vans.remove(object);
        log.info("Removed " + object.toString() + " van");
    }
}
