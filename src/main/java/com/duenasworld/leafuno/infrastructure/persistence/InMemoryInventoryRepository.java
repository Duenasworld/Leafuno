package com.duenasworld.leafuno.infrastructure.persistence;

import com.duenasworld.leafuno.application.InventoryRepository;
import com.duenasworld.leafuno.domain.model.Location;
import com.duenasworld.leafuno.domain.model.Plant;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Keeps plants and locations in memory while the application is running.
 * This temporary implementation can later be replaced by JSON-based storage.
 */
@Repository
public class InMemoryInventoryRepository implements InventoryRepository {

    private final List<Location> locations = new ArrayList<>();
    private final List<Plant> plants = new ArrayList<>();

    @Override
    public synchronized List<Location> findAllLocations() {
        return List.copyOf(locations);
    }

    @Override
    public synchronized Optional<Location> findLocationById(String id) {
        return locations.stream()
                .filter(location -> location.getId().equals(id))
                .findFirst();
    }

    @Override
    public synchronized void addLocation(Location location) {
        locations.add(location);
    }

    @Override
    public synchronized List<Plant> findAllPlants() {
        return List.copyOf(plants);
    }

    @Override
    public synchronized Optional<Plant> findPlantById(String id) {
        return plants.stream()
                .filter(plant -> plant.getId().equals(id))
                .findFirst();
    }

    @Override
    public synchronized void addPlant(Plant plant) {
        plants.add(plant);
    }
}
