package com.bootcampjava.starwars.Bootcamp.Java.Star.Wars.model;

public class Jedi {

    private int id;
    private String name;
    private int strength;
    private int version;

    public jedi(){}

    public Jedi(int id, String name, int strength, String version) {
        this.id = id;
        this.name = name;
        this.strength = strength;
        this.version = version;
    }

    public jedi(String name, int strength){
        this.name = name;
        this.strength = strength;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
