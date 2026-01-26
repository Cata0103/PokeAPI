package com.backend.application.search;

import com.backend.application.ports.in.Command;
import com.backend.domain.Search;
import org.springframework.web.client.RestTemplate;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

public class SearchByTypeOrGeneration implements SearchStrategy {
    @Override
    public void searchElements(ObjectMapper mapper, String searchJson, Search search, Command command, RestTemplate restTemplate) {
        String name = "";
        String sprite = "";
        JsonNode pokemons;
        if (command.domain().equals("type")) {
            pokemons = mapper.readTree(searchJson).path("pokemon");
            for (JsonNode pokemon : pokemons) {
                name = pokemon.path("pokemon").path("name").asString();
                sprite = pokemon.path("pokemon").path("url").asString();
                search.addSearch(name, sprite);
            }
        } else {
            pokemons = mapper.readTree(searchJson).path("pokemon_species");
            for (JsonNode pokemon : pokemons) {
                name = pokemon.path("name").asString();
                sprite = pokemon.path("url").asString();
                search.addSearch(name, sprite);
            }
        }
    }
}