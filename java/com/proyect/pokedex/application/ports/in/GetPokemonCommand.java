package com.proyect.pokedex.application.ports.in;

import lombok.Getter;

@Getter
public class GetPokemonCommand {
    private final String name;
    public GetPokemonCommand(String name) {
        this.name = name;
    }

}
