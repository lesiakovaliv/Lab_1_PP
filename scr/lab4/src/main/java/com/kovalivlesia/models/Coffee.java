package com.kovalivlesia.models;

import lombok.*;

@Getter
@Setter
@ToString(exclude = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Coffee {

    private Integer id;

    private String name;

    private CoffeeType type;
}
