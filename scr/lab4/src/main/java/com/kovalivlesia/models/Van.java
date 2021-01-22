package com.kovalivlesia.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@Setter
@Builder
@ToString
public class Van {

    private Map<CoffeePack, Integer> coffees;
}
