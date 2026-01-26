package com.backend.adapters.out;
import com.backend.application.ports.in.Command;
import com.backend.application.ports.out.LoadPokemonForm;
import com.backend.domain.PokemonForm;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LoadPokemonFormController implements LoadPokemonForm {
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper mapper = new ObjectMapper();
    @Override
    public PokemonForm loadPokemonForm(String form, Command command) {
        String url = command.url() + "pokemon-form" + "/" + form;
        String pokemonFormJson = restTemplate.getForObject(url, String.class);
        return mapper.readValue(pokemonFormJson, PokemonForm.class);
    }
    @Override
    public List<PokemonForm> getPokemonFormList(Command command) {
        List<PokemonForm>  pokemonFormList = new ArrayList<>();
        String pokemonJson = restTemplate.getForObject(command.url() + command.domain() + "/" + command.name(), String.class);
        JsonNode forms = mapper.readTree(pokemonJson).path("forms");
        for(JsonNode form : forms) {
            pokemonFormList.add(loadPokemonForm(form.get("name").asString(), command));
        }
        return pokemonFormList;
    }
}
