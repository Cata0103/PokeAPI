package com.backend.application.ports.in;

import com.backend.domain.PokemonForm;

import java.util.List;

public interface GetPokemonForm {
    List<PokemonForm> getPokemonForm(Command command);
}
