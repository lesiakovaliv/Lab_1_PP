package com.kovalivlesia.lab3.models;

import com.kovalivlesia.lab3.models.interfaces.Battle;

public class Droid implements Battle {
    protected final Double maxHealth;
    protected String name;
    protected Double health;
    protected Double damage;

    protected Integer energy;

    public Droid(String name, Double health, Double damage) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.damage = damage;
        this.energy = Constants.droidMaxEnergy;
    }

    public Droid copy() {
        return new Droid(name, health, damage);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getHealth() {
        return health;
    }

    public void setHealth(Double health) {
        if (health < 0) {
            this.health = 0.0;
            return;
        }
        if (health > maxHealth) {
            this.health = maxHealth;
            return;
        }
        this.health = health;
    }

    public Double getDamage() {
        return damage;
    }

    public void setDamage(Double damage) {
        this.damage = damage;
    }

    public Integer getEnergy() {
        return energy;
    }

    public Double getMaxHealth() {
        return maxHealth;
    }

    @Override
    public String toString() {
        return "Droid{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", damage=" + damage +
                ", energy=" + energy +
                '}';
    }

    public void minusEnergy() {
        this.energy--;
    }

    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public void battle(Droid droid) {
        droid.setHealth(droid.getHealth() - this.getDamage());
    }
}
