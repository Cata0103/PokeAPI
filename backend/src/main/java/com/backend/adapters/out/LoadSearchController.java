package com.backend.adapters.out;

import com.backend.application.ports.in.Command;
import com.backend.application.ports.out.LoadSearch;
import com.backend.application.search.SearchByNameOrPokedexNumber;
import com.backend.application.search.SearchByTypeOrGeneration;
import com.backend.application.search.SearchStrategy;
import com.backend.domain.Search;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import tools.jackson.databind.ObjectMapper;

import java.util.Map;

@Repository
public class LoadSearchController implements LoadSearch {
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public Map<String, String> loadSearch(Command command) {
        SearchStrategy searchStrategy;
        Search search = new Search();
        String url = command.url() + command.domain() + "/" + command.name();
        String searchJson = restTemplate.getForObject(url, String.class);
        if(command.domain().equals("pokemon")){
            searchStrategy = new SearchByNameOrPokedexNumber();
        }
        else {
            searchStrategy = new SearchByTypeOrGeneration();
        }
        searchStrategy.searchElements(mapper,searchJson,search,command,restTemplate);
        return search.getSearchList();
    }
}
