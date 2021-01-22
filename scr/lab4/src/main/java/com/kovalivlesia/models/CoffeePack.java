package com.kovalivlesia.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CoffeePack {

    private Pack pack;

    private Coffee coffee;

    private Double price;
}
