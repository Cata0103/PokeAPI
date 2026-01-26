package com.backend.adapters.in;

import com.backend.application.ports.in.Command;
import com.backend.application.services.GetPokemonService;
import com.backend.domain.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/pokedex/")
public class GetPokemonController {
    private final GetPokemonService getPokemon;
    @Autowired
    public  GetPokemonController(GetPokemonService getPokemon) {
        this.getPokemon = getPokemon;
    }
    @GetMapping(value = "/{domain}/{name}")
    public Pokemon getPokemon(@PathVariable String name, @PathVariable String domain) {
        Command command = new Command(name, domain,"https://pokeapi.co/api/v2/");
        return getPokemon.getPokemonByName(command);
    }
}

