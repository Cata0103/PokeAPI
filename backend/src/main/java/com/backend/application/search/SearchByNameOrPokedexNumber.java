package com.backend.application.search;

import com.backend.application.ports.in.Command;
import com.backend.domain.Search;
import org.springframework.web.client.RestTemplate;
import tools.jackson.databind.ObjectMapper;

public class SearchByNameOrPokedexNumber implements SearchStrategy{
    @Override
    public void searchElements(ObjectMapper mapper, String searchJson, Search search, Command command, RestTemplate restTemplate) {
        String name = mapper.readTree(searchJson).get("name").asString();
        String sprite = mapper.readTree(searchJson).path("sprites")
                .path("other").path("official-artwork")
                .path("front_default").asString();
        search.addSearch(name,sprite);
    }
}
