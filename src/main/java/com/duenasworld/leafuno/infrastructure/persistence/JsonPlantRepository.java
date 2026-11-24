package com.duenasworld.leafuno.infrastructure.persistence;

import com.duenasworld.leafuno.domain.model.PlantSpecies;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class JsonPlantRepository {
    private final List<PlantSpecies> species;

    public JsonPlantRepository() {
        try (InputStream input = getClass()
                .getResourceAsStream("/data/plant-species-seed.json")) {

            if (input == null) {
                throw new IllegalStateException("Artenkatalog nicht gefunden");
            }

            ObjectMapper mapper = new ObjectMapper();
            PlantSpeciesCatalogFile catalog =
                    mapper.readValue(input, PlantSpeciesCatalogFile.class);

            this.species = List.copyOf(catalog.getSpecies());

        } catch (IOException e) {
            throw new IllegalStateException("Artenkatalog konnte nicht gelesen werden", e);
        }
    }

    public List<PlantSpecies> findAllSpecies() {
        return species;
    }

    public Optional<PlantSpecies> findSpeciesById(String id) {
        return species.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();
    }
}