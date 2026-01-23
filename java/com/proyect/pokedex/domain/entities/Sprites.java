package com.proyect.pokedex.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sprites {
    @JsonProperty("back_default")
    private String backDefault;
    @JsonProperty("back_female")
    private String backFemale;
    @JsonProperty("back_shiny")
    private String backShiny;
    @JsonProperty("back_shiny_female")
    private String backShinyFemale;
    @JsonProperty("front_default")
    private String frontDefault;
    @JsonProperty("front_female")
    private String frontFemale;
    @JsonProperty("front_shiny")
    private String frontShiny;
    @JsonProperty("front_shiny_female")
    private String frontShinyFemale;
    public String getBackDefault() {
        return backDefault;
    }
    public String getBackFemale() {
        return backFemale;
    }
    public String getBackShiny() {
        return backShiny;
    }
    public String getBackShinyFemale() {
        return backShinyFemale;
    }
    public String getFrontDefault() {
        return frontDefault;
    }
    public String getFrontFemale() {
        return frontFemale;
    }
    public String getFrontShiny() {
        return frontShiny;
    }
    public String getFrontShinyFemale() {
        return frontShinyFemale;
    }
}
