package com.kovalivlesia.lab3.models;

import com.kovalivlesia.lab3.models.interfaces.Regenerate;

import static com.kovalivlesia.lab3.models.Constants.regenerateSize;

public class VampireDroid extends Droid implements Regenerate {
    public VampireDroid(String name, Double health, Double damage) {
        super(name, health, damage);
    }

    @Override
    public void regenerate(Droid droid) {
        if (energy > 0) {
            energy--;
            super.battle(droid);
            this.setHealth(this.getHealth() + regenerateSize);
        }
    }

    @Override
    public Droid copy() {
        return new VampireDroid(this.getName(), this.getHealth(), this.getDamage());
    }

    @Override
    public String toString() {
        return "VampireDroid{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", damage=" + damage +
                ", energy=" + energy +
                '}';
    }
}
