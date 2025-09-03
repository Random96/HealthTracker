package ru.emlsoft.healthtracker.model;

public class Dimension {
    private Integer Id;
    private String Name;

    public Integer getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Double getMultiplier(Dimension src ) {
        return 1.0;
    }
}
