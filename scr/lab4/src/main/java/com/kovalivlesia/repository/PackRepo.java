package com.kovalivlesia.repository;

import com.kovalivlesia.models.Pack;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;

@Log
public class PackRepo implements Repository<Pack> {

    private List<Pack> packs = new ArrayList<>();

    @Override
    public List<Pack> getAll() {
        return packs;
    }

    @Override
    public Pack add(Pack object) {
        packs.add(object);
        log.info("Added " + object.toString() + " pack");
        return object;
    }

    @Override
    public void delete(Pack object) {
        packs.remove(object);
        log.info("Removed " + object.toString() + " pack");
    }
}
