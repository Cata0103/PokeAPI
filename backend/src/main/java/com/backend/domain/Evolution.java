package com.backend.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Map;
import java.util.TreeMap;


@Getter
public class Evolution {
    @JsonProperty("evolution_chain")
    private Map<String, String> evolutionChain = new TreeMap<>();
    public void addEvolution(String name, String url){
        evolutionChain.put(name,url);
    }
}
