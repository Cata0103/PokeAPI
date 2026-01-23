package com.backend.application.ports.in;

import com.backend.domain.Pokemon;

public interface GetPokemon {
    Pokemon getPokemonByName(GetPokemonCommand command);
}