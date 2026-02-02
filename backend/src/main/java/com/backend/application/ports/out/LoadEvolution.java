package com.backend.application.ports.out;

import com.backend.application.ports.in.Command;
import com.backend.domain.Evolution;

public interface LoadEvolution {
    Evolution loadSpecies(Command command);
    Evolution loadEvolution(String url);
}
