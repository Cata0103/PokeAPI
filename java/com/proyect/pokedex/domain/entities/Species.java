package com.proyect.pokedex.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;
import java.util.TreeSet;

public class Species {
    private String name;
    @JsonProperty("evolution_chain")
    private Evolution evolution;
    @JsonProperty("evolves_from_species")
    private String evolvesFromSpecies;
    private final Set<String> varieties = new TreeSet<String>();

    public String getName() {
        return name;
    }

    public Evolution getEvolution() {
        return evolution;
    }

    public Set<String> getVarieties() {
        return varieties;
    }

    public String getEvolvesFromSpecies() {
        return evolvesFromSpecies;
    }
}
