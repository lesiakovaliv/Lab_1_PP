package com.kovalivlesia.lab3.models;

import com.kovalivlesia.lab3.models.interfaces.Regenerate;

public class RegenerateDroid extends Droid implements Regenerate {
    public RegenerateDroid(String name, Double health, Double damage) {
        super(name, health, damage);
    }

    @Override
    public void regenerate(Droid droid) {
        if (energy > 0) {
            energy--;
            this.setHealth(this.getHealth() + this.getDamage());
        }
    }

    @Override
    public Droid copy() {
        return new RegenerateDroid(this.getName(), this.getHealth(), this.getDamage());
    }

    @Override
    public String toString() {
        return "RegenerateDroid{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", damage=" + damage +
                ", energy=" + energy +
                '}';
    }
}
