package com.pokedex.controller;

import com.pokedex.domain.PokemonDTO;
import com.pokedex.domain.clients.pokemon.PokemonClientDTO;
import com.pokedex.service.PokedexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/pokedex")
public class PokedexController {

    private final PokedexService pokedexService;

    @Autowired
    public PokedexController(PokedexService pokedexService) {
        this.pokedexService = pokedexService;
    }


    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<PokemonDTO> getPokemonById(@PathVariable Long id) { //path??
        System.out.println("Hi id!!!!!!!!!");
        return ResponseEntity.ok(pokedexService.getPokemon(id));
    }

    @GetMapping("/name/{id}")
    public ResponseEntity<PokemonClientDTO> getPokemonByIdFromPkdx(@PathVariable Long id) {
        System.out.println("Hi there!!!!!!!!!");
        return ResponseEntity.ok(pokedexService.getPokemonById(id));
    }

    @GetMapping(value = "/all", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PokemonClientDTO>> getPokemonById() { //
        System.out.println("get Pokemon from Kanto region manually");
        return ResponseEntity.ok(pokedexService.getKantoPokemons());
    }
}
