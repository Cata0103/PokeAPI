package com.backend.adapters.in;


import com.backend.application.ports.in.Command;
import com.backend.application.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/pokedex/")
public class GetSearchController {
    private final SearchService searchService;
    @Autowired
    public GetSearchController(SearchService searchService) {
        this.searchService = searchService;
    }
    @GetMapping(value = "/search/{domain}/{element}")
    public Map<String,String> getSearch(@PathVariable String element, @PathVariable String domain) {
        Command command = new Command(element, domain, "https://pokeapi.co/api/v2/");
        return searchService.getSearch(command);
    }
}
