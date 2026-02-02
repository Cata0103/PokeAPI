package com.backend.adapters.in;


import com.backend.application.ports.in.Command;
import com.backend.application.ports.in.GetSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/pokedex/")
public class GetSearchController {
    private final GetSearch getSearch;
    @Autowired
    public GetSearchController( GetSearch getSearch) {
        this.getSearch = getSearch;
    }
    @GetMapping(value = "/search/{domain}/{element}")
    public Map<String,String> getSearch(@PathVariable String element, @PathVariable String domain) {
        Command command = new Command(element, domain, "https://pokeapi.co/api/v2/", "", "");
        return getSearch.getPokemonSearch(command);
    }
    @GetMapping(value = "/search/{domain}/{offset}/{limit}")
    public Map<String, String> getSearchPaginated(@PathVariable String domain, @PathVariable String offset, @PathVariable String limit) {
        Command command = new Command("", domain, "https://pokeapi.co/api/v2/", offset, limit);
        return getSearch.getPokemonSearch(command);
    }
    @GetMapping(value = "/search/pokemon-sprite/{name}")
    public Map<String, String> getSearchByName(@PathVariable String name) {
        Command command = new Command(name,"pokemon-sprite","https://pokeapi.co/api/v2/", "", "");
        return getSearch.getPokemonSearch(command);
    }
}
