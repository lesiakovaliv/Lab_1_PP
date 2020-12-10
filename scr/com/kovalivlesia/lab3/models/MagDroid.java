package com.kovalivlesia.lab3.models;

import com.kovalivlesia.lab3.models.interfaces.Health;

public class MagDroid extends Droid implements Health {
    public MagDroid(String name, Double health, Double damage) {
        super(name, health, damage);
    }

    @Override
    public void health(Droid droid) {
        if (energy > 0) {
            energy--;
            droid.setHealth(droid.getMaxHealth());
        }
    }

    @Override
    public Droid copy() {
        return new MagDroid(this.getName(), this.getHealth(), this.getDamage());
    }

    @Override
    public String toString() {
        return "MagDroid{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", damage=" + damage +
                ", energy=" + energy +
                '}';
    }
}
