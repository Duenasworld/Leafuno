package com.duenasworld.leafuno.infrastructure.persistence;

import com.duenasworld.leafuno.domain.model.PlantSpecies;

import java.util.List;

public class PlantSpeciesCatalogFile {
    private int version;
    private List<PlantSpecies> species;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public List<PlantSpecies> getSpecies() {
        return species;
    }

    public void setSpecies(List<PlantSpecies> species) {
        this.species = species;
    }
}