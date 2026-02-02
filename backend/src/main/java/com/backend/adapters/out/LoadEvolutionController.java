package com.backend.adapters.out;

import com.backend.application.ports.in.Command;
import com.backend.application.ports.out.LoadEvolution;
import com.backend.domain.Evolution;
import com.backend.domain.Species;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;


@Repository
public class LoadEvolutionController implements LoadEvolution {
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public Evolution loadEvolution(String url) {
        String evolutionJson = restTemplate.getForObject(url,String.class);
        Evolution evolution = new Evolution();
        JsonNode evolutionElement = mapper.readTree(evolutionJson).path("chain");
        while(evolutionElement!=null){
            evolution.addEvolution(evolutionElement.path("species").get("name").asString(),
                    evolutionElement.path("species").get("url").asString());
            evolutionElement = evolutionElement.path("evolves_to").get(0);
        }
        return evolution;
    }

    @Override
    public Evolution loadSpecies(Command command) {
        Species speciesObject = new Species();
        String url = command.url() + command.domain() + "/" + command.name();
        String speciesJson = restTemplate.getForObject(url, String.class);
        speciesObject.setPokemonEvolution(loadEvolution(mapper.readTree(speciesJson).path("evolution_chain").get("url").asString()));
        return speciesObject.getPokemonEvolution();
    }

}
