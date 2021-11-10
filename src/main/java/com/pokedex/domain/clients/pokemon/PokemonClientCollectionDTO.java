package com.pokedex.domain.clients.pokemon;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonClientCollectionDTO {
    private List<PokemonClientCollectionItemDTO> results;
}



