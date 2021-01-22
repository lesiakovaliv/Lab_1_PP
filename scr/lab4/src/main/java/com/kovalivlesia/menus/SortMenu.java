package com.kovalivlesia.menus;

import com.kovalivlesia.models.Van;
import com.kovalivlesia.repository.Repos;
import com.kovalivlesia.services.VanService;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SortMenu implements Menu{
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    @SneakyThrows
    public void menu() {
        VanService vanService = new VanService();

        System.out.println("Виберіть вантажівку");
        vanService.printVans(Repos.getVanRepo().getAll());

        System.out.print("Введіть номер: ");

        Van van = vanService.sort(Repos.getVanRepo().getAll().get(Integer.parseInt(bufferedReader.readLine()) - 1));

        System.out.println("Відсортовані товари в вантажівці \n" + van.toString());
    }
}
