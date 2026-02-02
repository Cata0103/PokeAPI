package com.backend.application.services;

import com.backend.application.ports.in.Command;
import com.backend.application.ports.in.GetVarieties;
import com.backend.application.ports.out.LoadVarieties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class GetVarietiesService implements GetVarieties {
    private final LoadVarieties loadVarieties;
    @Autowired
    public GetVarietiesService(LoadVarieties loadVarieties) {
        this.loadVarieties = loadVarieties;
    }
    @Override
    public Map<String,String> getVarieties(Command command) {
        return loadVarieties.loadVarieties(command.name(), command.domain(), command.url());
    }
}
