package com.example.starwarsapi.persistence.entity;


public class Planet {
    private int diameter;
    private String climate;
    private String name;
    private String terrain;

    public Planet(int diameter, String climate, String name, String terrain) {
        this.diameter = diameter;
        this.climate = climate;
        this.name = name;
        this.terrain = terrain;
    }

    public Planet() {
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }
}

