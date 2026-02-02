package com.backend.adapters.in;

import com.backend.application.ports.in.Command;
import com.backend.application.ports.in.GetEvolution;
import com.backend.domain.Evolution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokedex/")
public class GetEvolutionController {
    private final GetEvolution getEvolution;

    @Autowired
    public GetEvolutionController(GetEvolution getEvolution) {
        this.getEvolution = getEvolution;
    }

    @GetMapping("pokemon-evolution/{name}")
    public Evolution getPokemonEvolution(@PathVariable String name) {
    Command command = new Command(name, "pokemon-species", "https://pokeapi.co/api/v2/", "", "");
    return getEvolution.getEvolutionByName(command);
    }
}
