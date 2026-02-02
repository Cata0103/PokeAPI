package com.backend.application.ports.in;

import com.backend.domain.Evolution;

public interface GetEvolution {
    Evolution getEvolutionByName(Command command);
}
