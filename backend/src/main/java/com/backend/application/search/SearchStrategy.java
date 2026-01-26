package com.backend.application.search;

import com.backend.application.ports.in.Command;
import com.backend.domain.Search;
import org.springframework.web.client.RestTemplate;
import tools.jackson.databind.ObjectMapper;

public interface SearchStrategy {
    void searchElements(ObjectMapper mapper, String searchJson, Search search, Command command, RestTemplate restTemplate);
}
