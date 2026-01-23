package com.backend.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;


@Getter
public class Evolution {
    private int id;
    @JsonProperty("evolves_to")
    private ChainLink evolvesTo;

}
