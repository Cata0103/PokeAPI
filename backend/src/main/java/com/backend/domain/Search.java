package com.backend.domain;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Search {
    private final Map<String,String> searchList = new HashMap<>();
    public void addSearch(String name, String sprite){
        searchList.put(name,sprite);
    }
}
