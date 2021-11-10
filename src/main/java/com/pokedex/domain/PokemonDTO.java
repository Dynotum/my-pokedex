package com.pokedex.domain;


public class PokemonDTO {

    private String name;
    private double weight;
    private Long id;
    private boolean isCaught;

    public PokemonDTO(String name, double weight, Long id, boolean isCaught) {
        this.name = name;
        this.weight = weight;
        this.id = id;
        this.isCaught = isCaught;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public Long getId() {
        return id;
    }

    public boolean isCaught() {
        return isCaught;
    }
}
