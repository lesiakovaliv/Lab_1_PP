package com.kovalivlesia.lab3;

import com.kovalivlesia.lab3.models.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DroidRepository {
    private List<Droid> droids = new ArrayList<>();

    public Droid selectDroid() {
        printDroids();

        System.out.print("Input droid number: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int index;
        try {
            index = Integer.parseInt(bufferedReader.readLine()) - 1;
            if (index < 0 || index >= droids.size()) {
                if (index == -1) {
                    return null;
                }
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Incorrect input");
            return selectDroid();
        }

        return droids.get(index).copy();
    }

    public void addDroid() {
        printDroidTypes();

        System.out.print("Input droid type number: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int index = Integer.parseInt(bufferedReader.readLine());
            Droid droid = inputDroidValues();

            switch (index) {
                case 1:
                    droids.add(droid);
                    return;
                case 2:
                    droids.add(new JuniorKillerDroid(droid.getName(), droid.getHealth(), droid.getDamage()));
                    return;
                case 3:
                    droids.add(new KillerDroid(droid.getName(), droid.getHealth(), droid.getDamage()));
                    return;
                case 4:
                    droids.add(new MagDroid(droid.getName(), droid.getHealth(), droid.getDamage()));
                    return;
                case 5:
                    droids.add(new DoctorDroid(droid.getName(), droid.getHealth(), droid.getDamage()));
                    return;
                case 6:
                    droids.add(new RegenerateDroid(droid.getName(), droid.getHealth(), droid.getDamage()));
                    return;
                case 7:
                    droids.add(new VampireDroid(droid.getName(), droid.getHealth(), droid.getDamage()));
                    return;
                default:
                    throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Incorrect input");
            addDroid();
        }
    }

    public void printDroids() {
        int i = 1;
        for (Droid droid : droids) {
            System.out.println(i++ + " - " + droid.toString());
        }
    }

    private void printDroidTypes() {
        System.out.println("1 - Droid");
        System.out.println("2 - JuniorKillerDroid");
        System.out.println("3 - KillerDroid");
        System.out.println("4 - MagDroid");
        System.out.println("5 - DoctorDroid");
        System.out.println("6 - RegenerateDroid");
        System.out.println("7 - VampireDroid");
    }

    private Droid inputDroidValues() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Input droid name: ");
        String name = bufferedReader.readLine();
        System.out.println("Input droid health: ");
        Double health = Double.parseDouble(bufferedReader.readLine());
        System.out.println("Input droid damage: ");
        Double damage = Double.parseDouble(bufferedReader.readLine());

        return new Droid(name, health, damage);
    }
}
