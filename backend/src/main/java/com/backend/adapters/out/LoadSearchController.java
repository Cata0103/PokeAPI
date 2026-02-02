package com.backend.adapters.out;

import com.backend.application.ports.in.Command;
import com.backend.application.ports.out.LoadSearch;
import com.backend.application.search.*;
import com.backend.domain.Search;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import tools.jackson.databind.ObjectMapper;

import java.util.Map;
import java.util.Objects;

@Repository
public class LoadSearchController implements LoadSearch {
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public Map<String, String> loadSearch(Command command) {
        SearchStrategy searchStrategy;
        Search search = new Search();
        String url = command.url() + command.domain() + "/" + command.name();
        String searchJson;
        if(command.domain().equals("pokemon")){
            searchJson = restTemplate.getForObject(url, String.class);
            searchStrategy = new SearchByNameOrPokedexNumber();
        }
        else if(!Objects.equals(command.offset(), "")){
            //https://pokeapi.co/api/v2/pokemon-species/?offset=0&limit=20
            url = command.url() + command.domain() + "/" + "?offset=" + command.offset() + "&limit=" + command.limit();
            searchJson = restTemplate.getForObject(url, String.class);
            searchStrategy = new SearchByFilter();
        }
        else if(command.domain().equals("pokemon-sprite")){
            url = command.url() + "pokemon/" + command.name();
            System.out.println(url);
            searchJson = restTemplate.getForObject(url, String.class);
            searchStrategy = new SearchSprite();
        }
        else {
            searchJson = restTemplate.getForObject(url, String.class);
            searchStrategy = new SearchByTypeOrGeneration();
        }
        searchStrategy.searchElements(mapper,searchJson,search,command,restTemplate);
        return search.getSearchList();
    }
}
