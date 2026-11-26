package com.duenasworld.leafuno.application;

import com.duenasworld.leafuno.application.dto.LocationCreateInput;
import com.duenasworld.leafuno.application.dto.PlantCreateInput;
import com.duenasworld.leafuno.domain.model.*;
import com.duenasworld.leafuno.domain.rules.TemperatureAssessment;
import com.duenasworld.leafuno.infrastructure.persistence.JsonPlantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Coordinates application use cases and access to catalogue and inventory data.
 */
@Service
public class InventoryService {

    private final JsonPlantRepository speciesRepository;
    private final InventoryRepository inventoryRepository;
    private final TemperatureAssessment temperatureAssessment = new TemperatureAssessment();

    public InventoryService(
            JsonPlantRepository speciesRepository,
            InventoryRepository inventoryRepository
    ) {
        this.speciesRepository = speciesRepository;
        this.inventoryRepository = inventoryRepository;
    }

    public List<PlantSpecies> getAllPlantSpecies() {
        return speciesRepository.findAllSpecies();
    }

    public Optional<PlantSpecies> findPlantSpeciesById(String id) {
        return speciesRepository.findSpeciesById(id);
    }

    public List<Location> getAllLocations() {
        return inventoryRepository.findAllLocations();
    }

    public Optional<Location> findLocationById(String id) {
        return inventoryRepository.findLocationById(id);
    }

    public Location createLocation(LocationCreateInput input) {
        Location location = Location.createNew(
                input.roomName(),
                input.spotName(),
                input.lightLevel(),
                input.temperatureLevel()
        );
        inventoryRepository.addLocation(location);
        return location;
    }

    public List<Plant> getAllPlants() {
        return inventoryRepository.findAllPlants();
    }

    public Optional<Plant> findPlantById(String id) {
        return inventoryRepository.findPlantById(id);
    }

    public Plant createPlant(PlantCreateInput input) {
        Plant plant = Plant.createNew(
                input.personalName(),
                input.plantSpeciesId(),
                input.locationId(),
                input.lastWateredDate(),
                input.ownNotes()
        );
        inventoryRepository.addPlant(plant);
        return plant;
    }

    public TemperatureLevel getTemperatureRequirementForPlant(String plantId) {
        Plant plant = inventoryRepository.findPlantById(plantId)
                .orElseThrow(() -> new IllegalArgumentException("Plant not found"));

        PlantSpecies species = speciesRepository.findSpeciesById(plant.getPlantSpeciesId())
                .orElseThrow(() -> new IllegalArgumentException("Plant species not found"));

        return species.getTemperatureRequirement();
    }

    public AssessmentResult getTemperatureAssessmentForPlant(String plantId) {
        Plant plant = inventoryRepository.findPlantById(plantId)
                .orElseThrow(() -> new IllegalArgumentException("Plant not found"));

        Location location = inventoryRepository.findLocationById(plant.getLocationId())
                .orElseThrow(() -> new IllegalArgumentException("Plant location not found"));

        PlantSpecies species = speciesRepository.findSpeciesById(plant.getPlantSpeciesId())
                .orElseThrow(() -> new IllegalArgumentException("Plant species not found"));

        return temperatureAssessment.assess(species.getTemperatureRequirement(), location.getTemperatureLevel());
    }
}

