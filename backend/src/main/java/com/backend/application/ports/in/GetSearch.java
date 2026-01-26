package com.backend.application.ports.in;

import java.util.Map;

public interface GetSearch {
    Map<String,String> getSearch(Command command);
}
