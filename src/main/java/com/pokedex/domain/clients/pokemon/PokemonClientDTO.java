package com.pokedex.domain.clients.pokemon;

import lombok.Value;

// Thanks to lombok :)
@Value
public class PokemonClientDTO {
    Long id;
    String name;
    double weight;
}
