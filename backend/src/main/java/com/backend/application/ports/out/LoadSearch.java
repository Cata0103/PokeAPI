package com.backend.application.ports.out;

import com.backend.application.ports.in.Command;

import java.util.Map;

public interface LoadSearch {
    Map<String,String> loadSearch(Command command);
}
