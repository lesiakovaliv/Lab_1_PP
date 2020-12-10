package com.kovalivlesia.lab3.models;

import com.kovalivlesia.lab3.models.interfaces.Health;

import static com.kovalivlesia.lab3.models.Constants.healthSize;

public class DoctorDroid extends Droid implements Health {
    public DoctorDroid(String name, Double health, Double damage) {
        super(name, health, damage);
    }

    @Override
    public void health(Droid droid) {
        if (energy > 0) {
            energy--;
            droid.setHealth(droid.getHealth() + healthSize);
        }
    }

    @Override
    public Droid copy() {
        return new DoctorDroid(this.getName(), this.getHealth(), this.getDamage());
    }

    @Override
    public String toString() {
        return "DoctorDroid{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", damage=" + damage +
                ", energy=" + energy +
                '}';
    }
}
