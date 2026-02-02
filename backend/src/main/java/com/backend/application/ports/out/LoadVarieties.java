package com.backend.application.ports.out;


import java.util.Map;

public interface LoadVarieties {
    Map<String,String> loadVarieties(String pokemonName, String domain, String url);
}
