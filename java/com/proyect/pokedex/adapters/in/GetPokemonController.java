package com.proyect.pokedex.adapters.in;

import com.proyect.pokedex.application.ports.in.GetPokemonCommand;
import com.proyect.pokedex.application.services.GetPokemonService;
import com.proyect.pokedex.domain.entities.Pokemon;
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
    @GetMapping(value = "/pokemon/{nombre}")
    public Pokemon getPokemon(@PathVariable String nombre) {
        GetPokemonCommand command = new GetPokemonCommand(nombre);
        return getPokemon.getPokemonByName(command);
    }
}
