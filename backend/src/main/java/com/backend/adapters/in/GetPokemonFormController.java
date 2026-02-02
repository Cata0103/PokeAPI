package com.backend.adapters.in;

import com.backend.application.ports.in.Command;
import com.backend.application.ports.in.GetPokemonForm;
import com.backend.application.services.GetPokemonFormService;
import com.backend.domain.PokemonForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pokedex/")
public class GetPokemonFormController {
    private final GetPokemonForm getPokemonForm;
    @Autowired
    public GetPokemonFormController(GetPokemonFormService getPokemonForm) {
        this.getPokemonForm = getPokemonForm;
    }

    @GetMapping(value = "/pokemon-form/{name}")
    public List<PokemonForm> getPokemonForm( @PathVariable String name){
        Command command = new Command(name, "pokemon", "https://pokeapi.co/api/v2/", "", "");
        return getPokemonForm.getPokemonForm(command);
    }
}
