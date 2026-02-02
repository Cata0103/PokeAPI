package com.backend.adapters.out;

import com.backend.application.ports.out.LoadVarieties;
import com.backend.domain.Species;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.util.Map;

@Repository
public class LoadVarietiesController implements LoadVarieties {
    RestTemplate restTemplate = new RestTemplate();
    ObjectMapper mapper = new ObjectMapper();
    @Override
    public Map<String,String> loadVarieties(String pokemonName, String domain, String url) {
        Species species = new Species();
        String pokemonVarietiesJson = restTemplate.getForObject(url + domain + "/" + pokemonName, String.class);
        JsonNode varietiesJson = mapper.readTree(pokemonVarietiesJson).path("varieties");
        for (JsonNode variety: varietiesJson){
            species.addVariety(variety.path("pokemon").get("name").asString(),variety.path("pokemon").get("url").asString());
        }
        return species.getVarietiesList();
    }
}
