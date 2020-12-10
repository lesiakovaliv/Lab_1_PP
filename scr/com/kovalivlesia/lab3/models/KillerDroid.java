package com.kovalivlesia.lab3.models;

import com.kovalivlesia.lab3.models.interfaces.Kill;

public class KillerDroid extends Droid implements Kill {
    public KillerDroid(String name, Double health, Double damage) {
        super(name, health, damage);
    }

    @Override
    public void kill(Droid droid) {
        if (energy > 0) {
            energy--;
            droid.setHealth(0.0);
        }
    }

    @Override
    public Droid copy() {
        return new KillerDroid(this.getName(), this.getHealth(), this.getDamage());
    }

    @Override
    public String toString() {
        return "KillerDroid{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", damage=" + damage +
                ", energy=" + energy +
                '}';
    }
}