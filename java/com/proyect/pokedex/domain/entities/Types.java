package com.proyect.pokedex.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Types {
    private int id;
    private String name;
    @JsonProperty("damage_relations")
    private TypeRelations damageRelations;
    private String sprite;
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public TypeRelations getDamageRelations() {
        return damageRelations;
    }
    public String getSprite() { return sprite; }
}
