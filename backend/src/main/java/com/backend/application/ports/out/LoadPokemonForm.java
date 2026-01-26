package com.backend.application.ports.out;

import com.backend.application.ports.in.Command;
import com.backend.domain.PokemonForm;

import java.util.List;

public interface LoadPokemonForm {
    PokemonForm loadPokemonForm(String form, Command command);
    List<PokemonForm> getPokemonFormList(Command command);
}
