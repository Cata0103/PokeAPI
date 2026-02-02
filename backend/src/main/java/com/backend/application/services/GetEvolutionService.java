package com.backend.application.services;

import com.backend.application.ports.in.Command;
import com.backend.application.ports.in.GetEvolution;
import com.backend.application.ports.out.LoadEvolution;
import com.backend.domain.Evolution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetEvolutionService implements GetEvolution {
    private final LoadEvolution loadEvolution;

    @Autowired
    public GetEvolutionService(LoadEvolution loadEvolution) {
        this.loadEvolution = loadEvolution;
    }

    @Override
    public Evolution getEvolutionByName(Command command) {
        return loadEvolution.loadSpecies(command);
    }
}
