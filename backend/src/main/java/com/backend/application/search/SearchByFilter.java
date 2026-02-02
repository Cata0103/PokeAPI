package com.backend.application.search;

import com.backend.application.ports.in.Command;
import com.backend.domain.Search;
import org.springframework.web.client.RestTemplate;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

public class SearchByFilter implements SearchStrategy{

    @Override
    public void searchElements(ObjectMapper mapper, String searchJson, Search search, Command command, RestTemplate restTemplate) {
        JsonNode results = mapper.readTree(searchJson).path("results");
        for( JsonNode result: results) {
            String name = result.get("name").asString();
            String url = result.get("url").asString();
            String pokemonJson = restTemplate.getForObject(url, String.class);
            JsonNode varieties = mapper.readTree(pokemonJson).path("varieties");
            if(varieties.size() > 1) {
                System.out.println(name + " " + url);
                search.addSearch(name,url);
            }
        }
    }
}
