package com.pokedex.service.clients;

import com.pokedex.domain.clients.pokemon.PokemonClientCollectionDTO;
import com.pokedex.domain.clients.pokemon.PokemonClientDTO;
import com.pokedex.utils.FeignConfig;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "PokemonClientSrvc", url = "https://pokeapi.co/api/v2", configuration = FeignConfig.class)
public interface PokemonClientSrvc {

    @Headers("Content-Type: application/json")
    @RequestMapping(method = RequestMethod.GET, value = "/pokemon/{id}", consumes = "application/json")
    PokemonClientDTO getPokemonClientById(@PathVariable("id") Long id);

    @Headers("Content-Type: application/json")
    @RequestMapping(method = RequestMethod.GET, value = "/pokemon/?offset=0&limit=151", consumes = "application/json")
    PokemonClientCollectionDTO getKantoPokemons();

    @Headers("Content-Type: application/json")
    @RequestMapping(method = RequestMethod.GET, value = "/pokemon/?offset=0&limit=151", consumes = "application/json")
    PokemonClientCollectionDTO getKPokemons();

    @Headers("Content-Type: application/json")
    @RequestMapping(method = RequestMethod.GET, value = "/pokemon/{offset}", consumes = "application/json")
    PokemonClientDTO getPokemonClientByName(@RequestParam("offset") String offset);
}
