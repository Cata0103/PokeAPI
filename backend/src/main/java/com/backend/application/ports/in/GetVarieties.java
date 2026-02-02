package com.backend.application.ports.in;

import java.util.Map;

public interface GetVarieties {
    Map<String,String> getVarieties(Command command);
}
