package com.bootcampjava.starwars.Bootcamp.Java.Star.Wars.model;

public class Jedi {

    private Integer id;
    private String name;
    private int strength;
    private int version;

    public Jedi(){}

    public Jedi(Integer id, String name, int strength, int version) {
        this.id = id;
        this.name = name;
        this.strength = strength;
        this.version = version;
    }

    public jedi(String name, int strength){
        this.name = name;
        this.strength = strength;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
