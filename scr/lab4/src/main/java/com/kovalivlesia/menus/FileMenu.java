package com.kovalivlesia.menus;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static com.kovalivlesia.services.ReadAndWriteService.readFromFile;
import static com.kovalivlesia.services.ReadAndWriteService.writeToFile;

public class FileMenu implements Menu{
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    @SneakyThrows
    public void menu() {
        System.out.println("1 - Зберегти в файл");
        System.out.println("2 - Дістати з файлу");
        System.out.println("0 - Вийти");

        Integer c = Integer.parseInt(bufferedReader.readLine());
        if (c.equals(0)) {
            return;
        }

        System.out.print("Введіть назву файла: ");
        String fileName = bufferedReader.readLine();
        switch (c) {
            case 1:
                writeToFile(fileName);
                break;
            case 2:
                readFromFile(fileName);
                break;
        }
    }
}
