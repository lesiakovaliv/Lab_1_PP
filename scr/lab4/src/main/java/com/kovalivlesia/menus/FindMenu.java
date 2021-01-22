package com.kovalivlesia.menus;

import com.kovalivlesia.models.Van;
import com.kovalivlesia.repository.Repos;
import com.kovalivlesia.services.VanService;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindMenu implements Menu{

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    @SneakyThrows
    public void menu() {
        VanService vanService = new VanService();

        System.out.println("Виберіть вантажівку");
        vanService.printVans(Repos.getVanRepo().getAll());

        System.out.print("Введіть номер: ");
        Van van = Repos.getVanRepo().getAll().get(Integer.parseInt(bufferedReader.readLine()) - 1);

        System.out.print("Введіть ціну (0 - пропустити параметр): ");
        Double price = Double.parseDouble(bufferedReader.readLine());
        if (price <= 0) {
            price = null;
        }

        System.out.print("Введіть об'єм (0 - пропустити параметр): ");
        Double volume = price.parseDouble(bufferedReader.readLine());
        if (volume <= 0) {
            volume = null;
        }

        vanService.find(van, price, volume).forEach(coffeePack -> System.out.println(coffeePack.toString()));
    }
}
