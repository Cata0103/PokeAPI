package com.backend.application.services;

import com.backend.application.ports.in.GetPokemon;
import com.backend.application.ports.in.Command;
import com.backend.application.ports.out.LoadPokemon;
import com.backend.domain.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetPokemonService implements GetPokemon {
    private final LoadPokemon loadPokemon;

    @Autowired
    public GetPokemonService( LoadPokemon loadPokemon) {
        this.loadPokemon = loadPokemon;
    }

    @Override
    public Pokemon getPokemonByName(Command command) {
        return loadPokemon.loadPokemonByName(command);
    }

}
