package com.example.emt.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Accessory {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long ID;
    private String name;

    public Accessory(){}
    public Accessory(String name) {
        this.name = name;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
