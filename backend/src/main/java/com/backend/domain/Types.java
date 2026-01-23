package com.backend.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Types {
    private int id;
    private String name;
    @JsonProperty("damage_relations")
    private TypeRelations damageRelations;
    private String sprite;
}
