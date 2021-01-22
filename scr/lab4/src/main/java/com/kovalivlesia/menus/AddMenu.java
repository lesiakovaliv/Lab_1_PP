package com.kovalivlesia.menus;

import com.kovalivlesia.services.AddService;
import lombok.SneakyThrows;

public class AddMenu implements Menu{
    @Override
    @SneakyThrows
    public void menu() {
        AddService.menu();
    }
}
