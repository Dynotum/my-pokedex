package com.pokedex.domain.clients.pokemon;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonClientCollectionItemDTO {
    private String url;
    private String name;

}


