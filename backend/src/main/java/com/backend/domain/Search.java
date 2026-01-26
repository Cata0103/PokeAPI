package com.backend.domain;

import lombok.Getter;

import java.util.Map;
import java.util.TreeMap;

@Getter
public class Search {
    private final Map<String,String> searchList = new TreeMap<>();
    public void addSearch(String name, String sprite){
        searchList.put(name,sprite);
    }
}
