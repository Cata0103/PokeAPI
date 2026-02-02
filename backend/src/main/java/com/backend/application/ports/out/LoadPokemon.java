package com.backend.application.ports.out;

import com.backend.application.ports.in.Command;
import com.backend.domain.Pokemon;
import org.springframework.stereotype.Repository;
import tools.jackson.databind.JsonNode;

@Repository
public interface LoadPokemon {
    Pokemon loadPokemonByName(Command command);
    void loadPokemonElementsList(JsonNode elements, String group, Pokemon pokemon);
    void loadPokemonElementsMap(JsonNode elements, String group, Pokemon pokemon);
}
