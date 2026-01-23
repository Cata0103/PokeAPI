package com.proyect.pokedex.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import tools.jackson.databind.JsonNode;
import java.util.ArrayList;
import java.util.List;

public class Evolution {
    private int id;
    @JsonProperty("evolves_to")
    private ChainLink evolvesTo;

    public int getId() {
        return id;
    }

    public ChainLink getEvolvesTo() {
        return evolvesTo;
    }
}
