package com.backend.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;
import java.util.TreeMap;

@Data
public class Species {
    @JsonProperty("pokemon_evolution")
    private Evolution pokemonEvolution;
    @JsonProperty("varieties_list")
    private final Map<String, String> varietiesList = new TreeMap<>();
    public void addVariety(String variety, String url) {
        varietiesList.put(variety, url);
    }
}
