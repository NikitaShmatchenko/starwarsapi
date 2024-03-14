package com.example.starwarsapi.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "planet")
public class Planet extends CelestialBody {

    private String climate;
    private String terrain;

    public void describe() {
        System.out.println("The description of a planet.");
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }
}

