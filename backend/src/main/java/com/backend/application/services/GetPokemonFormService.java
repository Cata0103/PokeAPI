package com.backend.application.services;

import com.backend.application.ports.in.Command;
import com.backend.application.ports.in.GetPokemonForm;
import com.backend.application.ports.out.LoadPokemonForm;
import com.backend.domain.PokemonForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GetPokemonFormService implements GetPokemonForm {
    LoadPokemonForm loadPokemonForm;
    @Autowired
    public GetPokemonFormService(LoadPokemonForm loadPokemonForm) {
        this.loadPokemonForm = loadPokemonForm;
    }
    @Override
    public List<PokemonForm> getPokemonForm(Command command) {
        return loadPokemonForm.getPokemonFormList(command);
    }
}
