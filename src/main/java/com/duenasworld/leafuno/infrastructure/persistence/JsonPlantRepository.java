package com.duenasworld.leafuno.infrastructure.persistence;

import com.duenasworld.leafuno.domain.model.PlantSpecies;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

/**
 * Dies ist die Schicht, die den Artenkatalog aus der JSON-Datei lädt und Suchanfragen dazu beantwortet.
 * Diese Klasse kennt den Speicherort der JSON-Datei.
 */
@Repository
public class JsonPlantRepository {
    private final List<PlantSpecies> species;

    /**
     * The constructor is loading at start of spring the default plant repository from the JSON-file
     */
    public JsonPlantRepository() {
        try (InputStream input = getClass()
                .getResourceAsStream("/data/plant-species-seed.json")) {

            if (input == null) {
                throw new IllegalStateException("Artenkatalog nicht gefunden");
            }

            /* This object mapper transforms the JSON records into the required java objects */
            ObjectMapper mapper = new ObjectMapper();
            /* Here it maps the individual json fields per record to the matching fields within our classes */
            PlantSpeciesCatalogFile catalog =
                    mapper.readValue(input, PlantSpeciesCatalogFile.class);

            /* creates an un-mutable list of plantSpecies objects, this to protect unwanted deleting or adding */
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