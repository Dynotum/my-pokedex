package com.pokedex.service;

import com.pokedex.domain.clients.pokemon.PokemonClientCollectionDTO;
import com.pokedex.domain.clients.pokemon.PokemonClientCollectionItemDTO;
import com.pokedex.domain.clients.pokemon.PokemonClientDTO;
import com.pokedex.domain.PokemonDTO;
import com.pokedex.domain.entity.PokemonEntity;
import com.pokedex.persistence.PokemonRepository;
import com.pokedex.service.clients.PokemonClientSrvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PokedexService {

    private final PokemonRepository pokemonRepository;

    private final PokemonClientSrvc pokemonClientSrvc;

    @Autowired
    public PokedexService(PokemonRepository pokemonRepository, PokemonClientSrvc pokemonClientSrvc) {
        this.pokemonRepository = pokemonRepository;
        this.pokemonClientSrvc = pokemonClientSrvc;
    }

    public PokemonDTO getPokemon(Long id) {
        Long idT = pokemonRepository.getById(id).getId();

        PokemonDTO pokemonDTO = new PokemonDTO("Test", 1.1, id, true);
        return pokemonDTO;
    }

    public List<PokemonDTO> getAllCaught() {
        List<PokemonEntity> allPkmnCaught = pokemonRepository.findAll(); // [1..255]
        List<PokemonDTO> pokemonDTOS = new ArrayList<>();

        for (PokemonEntity pokemon : allPkmnCaught) {
            pokemonDTOS.add(new PokemonDTO("Test" + pokemon.getId(), (double) pokemon.getId(), pokemon.getId(), true));
        }

        return pokemonDTOS;
    }

//    public List<PokemonDTO> getAll() {
//        Set<Long> caughtPokemon = pokemonRepository.findAll().stream()
//                .map(PokemonEntity::getId)
//                .collect(Collectors.toSet()); // [1]
//
//        List<PokemonClientDTO> pokemonClientDTOS = pokemonClientSrvc.getAllPokemons(); // [1..255]
//
//        List<PokemonDTO> pokemonDTOS = new ArrayList<>();
//        for (PokemonClientDTO pokemonClientDTO : pokemonClientDTOS) {
//            boolean isCatched = caughtPokemon.contains(pokemonClientDTO.getId());
//            PokemonDTO pokemonDTO = buildPokemonDTO(pokemonClientDTO, isCatched);
//            pokemonDTOS.add(pokemonDTO);

//        }
//        [{
//            "name": "Bulbasaur", "weight": "66", "id": 1, "isCatched": true
//        },
//        {
//            "name": "Pikachu", "weight": "44", "id": 2, "isCatched": false
//        },
//        .
//        .
//        .
//        {}]
//        return new PokemonDTO(pokemonClientDTO.getName(), pokemonClientDTO.getWeigth(), pokemonClientDTO.getId(), isCaught);

//    }

    public PokemonDTO buildPokemonDTO(PokemonClientDTO pokemonClientDTO, boolean isCaught) {
        return new PokemonDTO(pokemonClientDTO.getName(), pokemonClientDTO.getWeight(), pokemonClientDTO.getId(), isCaught);
    }

    public PokemonClientDTO getPokemonById(Long id) {
        return pokemonClientSrvc.getPokemonClientById(id);
    }

    // TODO another endpoint
    public PokemonClientDTO getPokemonByName(String name) {
        return pokemonClientSrvc.getPokemonClientByName(name);
    }

    public List<PokemonClientDTO> getKantoPokemons() {
        PokemonClientCollectionDTO clientCollectionDTO = pokemonClientSrvc.getKantoPokemons();

        return clientCollectionDTO.getResults().stream().parallel()
                .map(PokemonClientCollectionItemDTO::getName)
                .map(this::getPokemonByName)
                .collect(Collectors.toList());
    }
}