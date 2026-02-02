package com.backend.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Set;

@Getter
public class TypeRelations {
    @JsonProperty("no_damage_to")
    private Set<String> noDamageTo;
    @JsonProperty("half_damage_to")
    private Set<String> halfDamageTo;
    @JsonProperty("double_damage_to")
    private Set<String> doubleDamageTo;
    @JsonProperty("no_damage_from")
    private Set<String> noDamageFrom;
    @JsonProperty("half_damage_from")
    private Set<String> halfDamageFrom;
    @JsonProperty("double_damage_from")
    private Set<String> doubleDamageFrom;
}
