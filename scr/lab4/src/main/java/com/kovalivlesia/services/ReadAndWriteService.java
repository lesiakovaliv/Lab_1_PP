package com.kovalivlesia.services;

import com.kovalivlesia.models.Package;
import com.kovalivlesia.models.*;
import com.kovalivlesia.repository.Repos;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ReadAndWriteService {
    private static String packStartConstant = "Packs";
    private static String vanStartConstant = "Vans";

    public static void readFromFile(String filename) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));

        String line = bufferedReader.readLine();
        while (!line.equals(packStartConstant)) {
            Coffee coffee = new Coffee();
            coffee.setId(Integer.parseInt(line));
            coffee.setName(bufferedReader.readLine());
            coffee.setType(CoffeeType.valueOf(bufferedReader.readLine()));

            Repos.getCoffeeRepo().add(coffee);

            line = bufferedReader.readLine();
        }

        line = bufferedReader.readLine();
        while (!line.equals(vanStartConstant)) {
            Pack pack;
            if (line.equals("Bank")) {
                pack = new Bank(
                        Integer.parseInt(bufferedReader.readLine()),
                        Double.parseDouble(bufferedReader.readLine()),
                        Double.parseDouble(bufferedReader.readLine())
                );
            } else {
                pack = new Package(
                        Integer.parseInt(bufferedReader.readLine()),
                        Double.parseDouble(bufferedReader.readLine())
                );
                bufferedReader.readLine();
            }

            Repos.getPackRepo().add(pack);

            line = bufferedReader.readLine();
        }

        line = bufferedReader.readLine();
        while (line != null) {
            line = bufferedReader.readLine();
            Map<CoffeePack, Integer> map = new HashMap<>();
            while (line != null && !line.equals("newVan")) {
                Integer amount = Integer.parseInt(line);
                CoffeePack coffeePack = new CoffeePack();
                coffeePack.setCoffee(getCoffeeById(Integer.parseInt(bufferedReader.readLine())));
                coffeePack.setPack(getPackById(Integer.parseInt(bufferedReader.readLine())));
                coffeePack.setPrice(Double.parseDouble(bufferedReader.readLine()));
                map.put(coffeePack, amount);
                line = bufferedReader.readLine();
            }
            Repos.getVanRepo().add(Van.builder().coffees(map).build());
        }
    }

    public static void writeToFile(String filename) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename));

        for (Coffee coffee : Repos.getCoffeeRepo().getAll()) {
            bufferedWriter.write(coffee.getId().toString());
            bufferedWriter.newLine();
            bufferedWriter.write(coffee.getName());
            bufferedWriter.newLine();
            bufferedWriter.write(coffee.getType().name());
            bufferedWriter.newLine();
        }

        bufferedWriter.write(packStartConstant);
        bufferedWriter.newLine();

        for (Pack pack : Repos.getPackRepo().getAll()) {
            if (pack instanceof Bank) {
                bufferedWriter.write("Bank");
            } else {
                bufferedWriter.write("Package");
            }
            bufferedWriter.newLine();
            bufferedWriter.write(pack.getId().toString());
            bufferedWriter.newLine();
            bufferedWriter.write(pack.getVolume().toString());
            bufferedWriter.newLine();
            bufferedWriter.write(pack.getVolumeOfContent().toString());
            bufferedWriter.newLine();
        }

        bufferedWriter.write(vanStartConstant);
        bufferedWriter.newLine();

        for (Van van : Repos.getVanRepo().getAll()) {
            bufferedWriter.write("newVan");
            bufferedWriter.newLine();
            for (Map.Entry<CoffeePack, Integer> coffeePack : van.getCoffees().entrySet()) {
                bufferedWriter.write(coffeePack.getValue().toString());
                bufferedWriter.newLine();
                bufferedWriter.write(coffeePack.getKey().getCoffee().getId().toString());
                bufferedWriter.newLine();
                bufferedWriter.write(coffeePack.getKey().getPack().getId().toString());
                bufferedWriter.newLine();
                bufferedWriter.write(coffeePack.getKey().getPrice().toString());
                bufferedWriter.newLine();
            }
        }

        bufferedWriter.close();
    }

    private static Coffee getCoffeeById(Integer integer) {
        for (Coffee coffee : Repos.getCoffeeRepo().getAll()) {
            if (coffee.getId().equals(integer)) {
                return coffee;
            }
        }
        return null;
    }

    private static Pack getPackById(Integer id) {
        for (Pack pack : Repos.getPackRepo().getAll()) {
            if (pack.getId().equals(id)) {
                return pack;
            }
        }
        return null;
    }
}
