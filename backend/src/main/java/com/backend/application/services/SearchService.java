package com.backend.application.services;

import com.backend.application.ports.in.Command;
import com.backend.application.ports.in.GetSearch;
import com.backend.application.ports.out.LoadSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SearchService implements GetSearch {
    private final LoadSearch loadSearch;

    @Autowired
    public SearchService(LoadSearch loadSearch) {
        this.loadSearch = loadSearch;
    }

    @Override
    public Map<String,String> getSearch(Command command){
        return loadSearch.loadSearch(command);
    }
}
