package com.backend.adapters.in;

import com.backend.application.ports.in.Command;
import com.backend.application.ports.in.GetVarieties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/pokedex/")
public class GetVarietiesController {
    private final GetVarieties getVarieties;
    @Autowired
    public GetVarietiesController(GetVarieties getVarieties) {
        this.getVarieties = getVarieties;
    }
    @GetMapping(value = "pokemon-varieties/{name}")
    public Map<String,String> getVarieties(@PathVariable String name) {
        Command command = new Command(name, "pokemon-species", "https://pokeapi.co/api/v2/", "", "");
        return getVarieties.getVarieties(command);
    }
}
