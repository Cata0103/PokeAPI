package com.proyect.pokedex.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public class TypeRelations {
    @JsonProperty("no_damage_to")
    private Set<String> noDamageTo;
    @JsonProperty("half_damage_to")
    private Set<String> halfDamageTo;
    @JsonProperty("double_damage_to")
    private Set<String> doubleDamageTo;
    @JsonProperty("no_damage_from")
    private Set<String> noDamageFrom;
    @JsonProperty("half_damage_from")
    private Set<String> halfDamageFrom;
    @JsonProperty("double_damage_from")
    private Set<String> doubleDamageFrom;
    public Set<String> getNoDamageTo() {
        return noDamageTo;
    }
    public Set<String> getHalfDamageTo() {
        return halfDamageTo;
    }
    public Set<String> getDoubleDamageTo() {
        return doubleDamageTo;
    }
    public Set<String> getNoDamageFrom() {
        return noDamageFrom;
    }
    public Set<String> getHalfDamageFrom() {
        return halfDamageFrom;
    }
    public Set<String> getDoubleDamageFrom() {
        return doubleDamageFrom;
    }
}
