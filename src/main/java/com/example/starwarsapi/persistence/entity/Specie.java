package com.example.starwarsapi.persistence.entity;

public class Specie {
    private int averageHeight;
    private String language;
    private String name;

    public Specie(int averageHeight, String language, String name) {
        this.averageHeight = averageHeight;
        this.language = language;
        this.name = name;
    }

    public Specie() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getAverageHeight() {
        return averageHeight;
    }

    public void setAverageHeight(int averageHeight) {
        this.averageHeight = averageHeight;
    }
}

