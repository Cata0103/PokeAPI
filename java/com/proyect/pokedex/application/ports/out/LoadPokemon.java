package com.proyect.pokedex.application.ports.out;

import com.proyect.pokedex.application.ports.in.GetPokemonCommand;
import com.proyect.pokedex.domain.entities.Pokemon;
import org.springframework.stereotype.Repository;
import tools.jackson.databind.JsonNode;
import java.util.List;
import java.util.Map;
@Repository
public interface LoadPokemon {
    Pokemon loadPokemonByName(GetPokemonCommand command);
    void loadPokemonElementsList(JsonNode elements, String group, Pokemon pokemon);
    void loadPokemonElementsMap(JsonNode elements, String group, Pokemon pokemon);
}
