package com.kovalivlesia.lab3.models;

import com.kovalivlesia.lab3.models.interfaces.Kill;

public class JuniorKillerDroid extends Droid implements Kill {
    public JuniorKillerDroid(String name, Double health, Double damage) {
        super(name, health, damage);
    }

    @Override
    public void kill(Droid droid) {
        if (energy > 0) {
            energy--;
            droid.setHealth(droid.getHealth() - droid.getMaxHealth() / 2);
        }
    }

    @Override
    public Droid copy() {
        return new JuniorKillerDroid(this.getName(), this.getHealth(), this.getDamage());
    }

    @Override
    public String toString() {
        return "JuniorKillerDroid{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", damage=" + damage +
                ", energy=" + energy +
                '}';
    }
}