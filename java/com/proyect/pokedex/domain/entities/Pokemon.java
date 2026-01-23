package com.proyect.pokedex.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

@Data
public class Pokemon {
    private int id;
    private String name;
    @JsonProperty("base_experience")
    private int baseExperience;
    private int height;
    private int weight;
    private Sprites sprites;
    private Cries cries;
    @JsonProperty("pokemon_species")
    private String species;
    @JsonProperty("pokemon_forms")
    private Set<String> forms = new TreeSet<>();
    @JsonProperty("pokemon_stats")
    private final Map<String,Integer> stats = new HashMap<>();
    @JsonProperty("pokemon_types")
    private final Set<String> types = new TreeSet<>();
    @JsonProperty("pokemon_abilities")
    private final Set<String> abilities =  new TreeSet<>();
    public Pokemon() {}
    public void addStats(String key, int value) {
        stats.put(key, value);
    }
    public void addType(String type){
        types.add(type);
    }
    public void addAbility(String ability){
        abilities.add(ability);
    }
    public void addForm(String form){
        forms.add(form);
    }
}

