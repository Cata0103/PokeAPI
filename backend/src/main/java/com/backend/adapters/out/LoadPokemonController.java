package com.backend.adapters.out;

import com.backend.application.ports.in.Command;
import com.backend.application.ports.out.LoadPokemon;
import com.backend.domain.Pokemon;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;
import java.util.Map;

@Repository
public class LoadPokemonController implements LoadPokemon {
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper mapper = new ObjectMapper();
    @Override
    public void loadPokemonElementsList(JsonNode elements, String group, Pokemon pokemon){
        for( JsonNode element: elements){
            if(group.equals("ability")){
                pokemon.addAbility(element.path(group).path("name").asString());
            } else if(group.equals("type")){
                pokemon.addType(element.path(group).path("name").asString());
            } else {
                pokemon.addForm(element.path("name").asString());
            }
        }
    }
    @Override
    public void loadPokemonElementsMap(JsonNode elements, String group, Pokemon pokemon){
        for (JsonNode element : elements) {
            pokemon.addStats(element.path("stat").path("name").asString(),element.path("base_stat").asInt());
        }
    }
    @Override
    public Pokemon loadPokemonByName(Command command) {
        String url = command.url() + command.domain() + "/" + command.name();
        String pokemonJSON = restTemplate.getForObject(url, String.class);
        Pokemon pokemon = mapper.readValue(pokemonJSON, Pokemon.class);
        Map<String,String> elementsArray = Map.of("abilities", "ability","types", "type", "forms", "");
        for (Map.Entry<String, String> element : elementsArray.entrySet()) {
            loadPokemonElementsList(mapper.readTree(pokemonJSON).path(element.getKey()), element.getValue(), pokemon);
        }
        loadPokemonElementsMap(mapper.readTree(pokemonJSON).path("stats"), "name", pokemon);
        pokemon.setFrontOfficialArtwork(mapper.readTree(pokemonJSON).path("sprites")
                .path("other")
                .path("official-artwork")
                .path("front_default").asString());
        pokemon.setSpecies(mapper.readTree(pokemonJSON).path("species")
                .path("name").asString());
        return pokemon;
    }
}