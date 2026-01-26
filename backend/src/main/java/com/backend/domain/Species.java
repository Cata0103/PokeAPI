package com.backend.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Set;
import java.util.TreeSet;

@Getter
public class Species {
    private String name;
    @JsonProperty("evolution_chain")
    private Evolution evolution;
    @JsonProperty("evolves_from_species")
    private String evolvesFromSpecies;
    private final Set<String> varieties = new TreeSet<String>();
}
