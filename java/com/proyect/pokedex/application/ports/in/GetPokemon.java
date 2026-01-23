package com.proyect.pokedex.application.ports.in;

import com.proyect.pokedex.domain.entities.Pokemon;

public interface GetPokemon {
    Pokemon getPokemonByName(GetPokemonCommand command);
}
