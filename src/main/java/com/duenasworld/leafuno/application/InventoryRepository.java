package com.duenasworld.leafuno.application;

import com.duenasworld.leafuno.domain.model.Location;
import com.duenasworld.leafuno.domain.model.Plant;

import java.util.List;
import java.util.Optional;

/**
 * Defines the operations used by the application to access plants and locations.
 * The application does not depend on a specific storage implementation.
 */
public interface InventoryRepository {

    List<Location> findAllLocations();

    Optional<Location> findLocationById(String id);

    void addLocation(Location location);

    List<Plant> findAllPlants();

    Optional<Plant> findPlantById(String id);

    void addPlant(Plant plant);
}
