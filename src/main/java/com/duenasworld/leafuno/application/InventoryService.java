package com.duenasworld.leafuno.application;

import com.duenasworld.leafuno.domain.model.PlantSpecies;
import com.duenasworld.leafuno.infrastructure.persistence.JsonPlantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {
    private final JsonPlantRepository plantRepository;

    public InventoryService(JsonPlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    public List<PlantSpecies> getAllPlantSpecies() {
        return plantRepository.findAllSpecies();
    }

    public Optional<PlantSpecies> findPlantSpeciesById(String id) {
        return plantRepository.findSpeciesById(id);
    }
}