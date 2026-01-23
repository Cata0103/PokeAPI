package com.proyect.pokedex.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChainLink {
    private Species species;
    @JsonProperty("evolves_to")
    private ChainLink evolvesTo;

    public Species getSpecies() {
        return species;
    }

    public ChainLink getEvolvesTo() {
        return evolvesTo;
    }
}
