package com.kovalivlesia.services;

import com.kovalivlesia.models.Package;
import com.kovalivlesia.models.*;
import com.kovalivlesia.repository.Repos;
import lombok.extern.java.Log;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Log
public class AddServiceTest {
    static InputStream def = System.in;

    @BeforeClass
    public static void beforeClass() {
        String in = "2\r\n2\r\n20\r\n" +
                "2\r\n1\r\n20\r\n15\r\n" +
                "1\r\nName\r\n0\r\n" +
                "3\r\ny\r\n1\r\n1\r\n10\r\n10\r\nn";
        System.setIn(new ByteArrayInputStream(in.getBytes()));
    }

    @Test
    public void testAddCoffee() throws IOException {
        AddService.menu();
        List<Coffee> coffees = Repos.getCoffeeRepo().getAll();
        Coffee coffee = coffees.get(coffees.size() - 1);
        assertEquals("Name", coffee.getName());
        assertEquals(CoffeeType.values()[0], coffee.getType());
    }

    @Test
    public void testAddPackBank() throws IOException {
        AddService.menu();
        List<Pack> packs = Repos.getPackRepo().getAll();
        Pack pack = packs.get(packs.size() - 1);
        assertTrue(pack instanceof Bank);
        assertEquals(java.util.Optional.of(20.0), java.util.Optional.of(pack.getVolume()));
        assertEquals(java.util.Optional.of(15.0), java.util.Optional.of(pack.getVolumeOfContent()));
    }


    @Test
    public void testAddPackPackage() throws IOException {
        AddService.menu();
        List<Pack> packs = Repos.getPackRepo().getAll();
        Pack pack = packs.get(packs.size() - 1);
        assertTrue(pack instanceof Package);
        assertEquals(java.util.Optional.of(20.0), java.util.Optional.of(pack.getVolume()));
        assertEquals(java.util.Optional.of(20.0), java.util.Optional.of(pack.getVolumeOfContent()));
    }

    @Test
    public void testAddVan() throws IOException {
        AddService.menu();
        List<Van> vans = Repos.getVanRepo().getAll();
        Van van = vans.get(vans.size() - 1);
        for (CoffeePack coffeePack : van.getCoffees().keySet()) {
            assertEquals(java.util.Optional.of(10), java.util.Optional.of(van.getCoffees().get(coffeePack)));
            assertEquals(java.util.Optional.of(10.0), java.util.Optional.of(coffeePack.getPrice()));
        }
    }

    @AfterClass
    public static void afterAll() {
        System.setIn(def);
    }

}
