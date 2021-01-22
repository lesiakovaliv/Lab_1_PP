package com.kovalivlesia.services;

import com.kovalivlesia.models.Package;
import com.kovalivlesia.models.*;
import com.kovalivlesia.repository.Repos;
import lombok.extern.java.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log
public class AddService {

   static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void menu() throws IOException {
        System.out.println("1 - Додати каву");
        System.out.println("2 - Додати упаковку");
        System.out.println("3 - Завантажити фургончик");
        System.out.println("0 - Вийти");

        Integer c = Integer.parseInt(bufferedReader.readLine());

        switch (c) {
            case 0:
                log.warning("Exit from app");
                return;
            case 1:
                addCoffee();
                break;
            case 2:
                addPack();
                break;
            case 3:
                addVan();
                break;
        }
    }

    private static void addCoffee() throws IOException {
        System.out.print("Введіть ім'я: ");
        String name = bufferedReader.readLine().trim();
        System.out.println("Виберіть тип");
        for (CoffeeType coffeeType : CoffeeType.values()) {
            System.out.println(coffeeType.ordinal() + " - " + coffeeType.name());
        }
        List<Coffee> list = Repos.getCoffeeRepo().getAll();
        Repos.getCoffeeRepo().add(new Coffee(
                list.size() == 0 ? 0 : list.get(list.size() - 1).getId() + 1,
                name,
                CoffeeType.values()[Integer.parseInt(bufferedReader.readLine())]
        ));
    }

    private static void addPack() throws IOException {
        System.out.println("1 - банка");
        System.out.println("2 - пакет");
        Integer index = Integer.parseInt(bufferedReader.readLine());
        if (index.equals(1)) {
            System.out.print("Введіть об'єм банки: ");
            Double volume = Double.parseDouble(bufferedReader.readLine());
            System.out.print("Введіть об'єм вмісту: ");
            Double volumeOfContent = Double.parseDouble(bufferedReader.readLine());
            if (volumeOfContent > volume) {
                System.out.println("Неможливо додати банку з вмістом більши за об'єм банки");
                return;
            }

            List<Pack> packs = Repos.getPackRepo().getAll();
            Repos.getPackRepo().add(new Bank(
                    packs.size() == 0 ? 0 : packs.get(packs.size() - 1).getId() + 1,
                    volume,
                    volumeOfContent
            ));
        }
        if (index.equals(2)) {
            System.out.print("Введіть об'єм: ");
            Double volume = Double.parseDouble(bufferedReader.readLine());

            List<Pack> packs = Repos.getPackRepo().getAll();
            Repos.getPackRepo().add(new Package(
                    packs.size() == 0 ? 0 : packs.get(packs.size() - 1).getId() + 1,
                    volume
            ));
        }
    }

    private static void addVan() throws IOException {
        System.out.print("Добавити товар ? y/n - ");
        String answer = bufferedReader.readLine().trim();
        Map<CoffeePack, Integer> contentOfVan = new HashMap<>();
        while (answer.equals("y") || answer.equals("Y")) {
            CoffeePack coffeePack = new CoffeePack();

            System.out.println("Виберіть каву: ");
            int i = 1;
            for (Coffee coffee : Repos.getCoffeeRepo().getAll()) {
                System.out.println(i++ + " - " + coffee.toString());
            }
            coffeePack.setCoffee(Repos.getCoffeeRepo().getAll().get(Integer.parseInt(bufferedReader.readLine()) - 1));

            System.out.println("Виберіть упаковку: ");
            i = 1;
            for (Pack pack : Repos.getPackRepo().getAll()) {
                System.out.println(i++ + " - " + pack.toString());
            }
            coffeePack.setPack(Repos.getPackRepo().getAll().get(Integer.parseInt(bufferedReader.readLine()) - 1));

            System.out.print("Введіть ціну: ");
            coffeePack.setPrice(Double.parseDouble(bufferedReader.readLine()));

            System.out.print("Введіть кількість: ");
            Integer amount = Integer.parseInt(bufferedReader.readLine());
            contentOfVan.put(coffeePack, amount);

            System.out.print("Добавити товар ? y/n - ");
            answer = bufferedReader.readLine().trim();
        }
        Repos.getVanRepo().add(Van.builder().coffees(contentOfVan).build());
    }
}
