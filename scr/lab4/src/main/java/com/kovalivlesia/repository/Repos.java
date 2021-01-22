package com.kovalivlesia.repository;

public class Repos {

    private static CoffeeRepo coffeeRepo = new CoffeeRepo();

    private static PackRepo packRepo = new PackRepo();

    private static VanRepo vanRepo = new VanRepo();

    public static CoffeeRepo getCoffeeRepo() {
        return coffeeRepo;
    }

    public static PackRepo getPackRepo() {
        return packRepo;
    }

    public static VanRepo getVanRepo() {
        return vanRepo;
    }
}
