package com.backend.application.search;

import com.backend.application.ports.in.Command;
import com.backend.domain.Search;
import org.springframework.web.client.RestTemplate;
import tools.jackson.databind.ObjectMapper;

public class SearchSprite implements SearchStrategy{
    @Override
    public void searchElements(ObjectMapper mapper, String searchJson, Search search, Command command, RestTemplate restTemplate) {
        String pokemonId = mapper.readTree(searchJson).get("id").asString();
        String pokemonName = mapper.readTree(searchJson).get("name").asString();
        String pokemonSprite = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/" + pokemonId + ".png";
        search.addSearch(pokemonName,pokemonSprite);
    }
}
