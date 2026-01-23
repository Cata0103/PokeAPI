package com.proyect.pokedex.application.services;

import com.proyect.pokedex.application.ports.in.GetPokemon;
import com.proyect.pokedex.application.ports.in.GetPokemonCommand;
import com.proyect.pokedex.application.ports.out.LoadPokemon;
import com.proyect.pokedex.domain.entities.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;
@Service
public class GetPokemonService implements GetPokemon {
    private LoadPokemon loadPokemon;

    @Autowired
    public GetPokemonService( LoadPokemon loadPokemon) {
        this.loadPokemon = loadPokemon;
    }

    @Override
    public Pokemon getPokemonByName(GetPokemonCommand command) {
        return loadPokemon.loadPokemonByName(command);
    }

}
