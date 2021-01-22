package com.kovalivlesia;

import com.kovalivlesia.menus.AddMenu;
import com.kovalivlesia.menus.FileMenu;
import com.kovalivlesia.menus.FindMenu;
import com.kovalivlesia.menus.Menu;
import com.kovalivlesia.menus.SortMenu;
import com.kovalivlesia.services.ErrorService;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {

    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    @SneakyThrows
    public static void main(String[] args) {
        List<Menu> menuList = Arrays.asList(new AddMenu(),new FileMenu(),new SortMenu(),new FindMenu());
        while (true) {
            String in = menu();
            try {
                if (in.trim().equals("0")) {
                    return;
                }
                menuList.get(Integer.parseInt(in) - 1).menu();
            } catch (IndexOutOfBoundsException e) {
                ErrorService.error("Incorrect input - " + in);
            }
        }
    }

    @SneakyThrows
    private static String menu() {
        System.out.println("1 - Додати продукти або завантажити фургон");
        System.out.println("2 - Завантажити з файлу або зберегти в файл дані");
        System.out.println("3 - Відсортувати продукти в бусі");
        System.out.println("4 - Знайти товари за критеріями в бусі");
        System.out.println("0 - Вийти");

        return bufferedReader.readLine();
    }
}
